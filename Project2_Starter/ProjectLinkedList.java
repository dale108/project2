import java.util.*;

/**
 * This is a doubly linked, circular list which can hold any type of element.  
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProjectLinkedList<E> implements List<E>
{

    LinkedListNode<E> head;
    LinkedListNode<E> end;
    private int size;

    public ProjectLinkedList() {
        head = new LinkedListNode(null);
        end = new LinkedListNode(null);
        reset(); // call reset here to set the links to circular
    }

    /**
     *  Adds value to the end of the list.
     */
    public void add(E value) {
        add(size,value); // adds to the end of the list.
    }

    /**
     * Adds value at specific index
     */
    public void add(int index, E data)  throws IndexOutOfBoundsException {
        checkIndex(index); // ensure that index is valid, otherwise crashes program
        LinkedListNode<E> curr = nodeAt(index-1);
        LinkedListNode<E> addNode = new LinkedListNode(data, curr.next, curr);
        curr.next = addNode;
        addNode.next.previous = addNode;
        size++;
    }

    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    public E get(int idx) {
        checkIndex(idx);
        LinkedListNode<E> curr = nodeAt(idx);
        return curr.data;
    }

    /** 
     * Returns whether or not the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Sets a value at a given index
     */
    public void set(int idx, E newVal) {
        checkIndex(idx);
        LinkedListNode curr = nodeAt(idx);
        curr.data = newVal;
    }

    /** 
     * returns the size of the list
     */
    public int size(){
        return size;
    }

    public void remove(int idx) {
        checkIndex(idx);
        LinkedListNode curr = nodeAt(idx-1);
        curr.next = curr.next.next;
        curr.next.previous = curr;
        size--;
    }

    // List is circular, so this is necessary
    public void reset() {
        head.next = end;
        end.next = head;
    }

    /**
     * Simple iteration through the list to find the index of a given element.
     * if the target is not found in the list, returns -1.
     */
    public int indexOf(E target) {
        int idx = 0;
        LinkedListNode current = head;
        while(current != end) {
            if(current.data.equals(target)) {
                return idx;
            }
            else {
                current = current.next;
                idx++;
            }
        }
        return -1; // if not found, returns negative number
    }

    /**
     * This is a helper method for us to find the node at a certain index - I've made
     * some changes to the algorithm in the textbook to demonstrate a different approach. This method is dynamic
     * in that it it searches from wither the beginning or end of the list depending on if
     * the index value is greater or lesser than size/2.
     */
    private LinkedListNode<E> nodeAt(int index) {
        LinkedListNode<E> curr;
        if(index < size/2) { // If the element is nearer to the beginning than the end
            curr = head;
            int count = 0;
            // I'm using a while loop here just so the  program is different from source material
            while(count < index + 1) { 
                curr = curr.next;
                count++;
            }
            return curr;
        }
        else { // identical structture but starting from the end.
            curr = end;
            int count = size;
            while(count > index) {
                curr = curr.previous;
                count--;
            }
        }
        return curr;
    }

    /**
     * Helper method to assure index won't cause any problems.
     */
    private boolean checkIndex(int idx) {
        if(idx > size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    // This is another custom implementation which is integral to the functioning of the program
    public Object getLastElement() { 
        return (Object) end.previous.data;
    }

    /**
     * This is straight form the textbook - returns an iterator for the Linked list;
     */
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + head.next.data;
            LinkedListNode<E> current = head.next.next;
            while (current != end) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    /** 
     * ensures that there are no duplicate objects in the list. This is useful for making a 
     * linked set, without having to change data types.
     */
    public void removeDuplicates() {
        if(head != null) {
            LinkedListNode curr = head;
            while(curr.next != head && curr.next.next != head) {
                if(curr.data.equals(curr.next.data)) {
                    curr.next = curr.next.next;
                }
                else {
                    curr = curr.next;
                }
            }
            if(curr.next.data == curr.data) {
                curr.next = null;
            }
        }
    }

    public Room[] toArray() {
        Room[] arr = new Room[size];

        LinkedListNode curr = head.next;
        for(int i = 0; i < size; i++) {
            arr[i] = (Room) curr.data;
            curr = curr.next;
        }
        mergeSort(arr);
        return arr;
    }

    public Room[] mergeSort(Room[] arr) {

        if(arr.length > 1) {

            Room[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
            Room[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);

           
        }
        return arr;
    }

    public void merge(Room[] result, Room[] left, Room[] right) {
        int i1 = 0; 
        int i2 = 0;
        Room a = (Room) left[i1];
        Room b = (Room) right[i2];
        int comparison =  a.compareTo(b);
        for(int i = 0; i < result.length; i++) {
            if( i2 >= right.length || i1 < left.length && comparison <= 0) {
                result[i] = left[i1];
                i1++;
            }
            else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    /**
     * Nested classes make this implementation easier - this way we don't need getters and
     * setters for next, previous and data fields. Has 4 constructors to make the class as
     * as possible.
     */
    private static class LinkedListNode<E> {
        public E data;
        public LinkedListNode next;
        public LinkedListNode previous;

        // very basic - will probably never need this - only for empty lists
        public LinkedListNode() {
            this.next = null;
            this.data = null;
        }

        public LinkedListNode(E data) {
            this.next = null;
            this.data = null;
            this.data = data;
        }

        // constructor for initial elements
        public LinkedListNode (E data,LinkedListNode next) {
            this.next = next;
            this.previous = null;
            this.data = data;
        }

        // robust constructor
        public LinkedListNode ( E data, LinkedListNode next, LinkedListNode prev) {
            this.next = next;
            this.previous = prev;
            this.data = data;
        }
    }

    // this is adapted from the textbook - the order of methods will be the same as the
    // textbook implementation. 
    private class LinkedIterator implements Iterator<E> {
        private LinkedListNode<E> curr; 
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            curr = head.next;
            removeOK = false;
        }

        public boolean hasNext() {
            return curr != end;
        }

        //only works if the iterator has a next value to take.
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = curr.data;
            curr = curr.next;
            removeOK = true;
            return result;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            LinkedListNode<E> prev2 = curr.previous.previous;
            prev2.next = curr;
            curr.previous = prev2;
            size--;
            removeOK = false;
        }

    }
}

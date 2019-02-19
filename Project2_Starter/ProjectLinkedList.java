import java.util.*;
/**
 * This is a doubly linked, circular list which can hold any type of element. My concept is to 
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
        reset();
    }

    public void add(E value) {
        add(size,value);
    }

    public void add(int index, E data) {
        checkIndex(index);
        LinkedListNode<E> curr = nodeAt(index-1);
        LinkedListNode<E> addNode = new LinkedListNode(data, curr.next, curr);
        curr.next = addNode;
        addNode.next.previous = addNode;
        size++;
    }

    // public boolean contains(E val) {
        // LinkedListNode curr = head;
        // while(curr != end) {
            // if(curr.data.equals(val)){
                // return true;
            // }
            // curr = curr.next;
        // }
        // return false;
    // }
    
        // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    public E get(int idx) {
        checkIndex(idx);
        LinkedListNode<E> curr = nodeAt(idx);
        return curr.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int idx, E newVal) {
        checkIndex(idx);
        LinkedListNode curr = nodeAt(idx);
        curr.data = newVal;
    }

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
     * some changes to the algorithm in the textbook for differentiation. This method is dynamic
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
     * Nested classes make this implementation easier - this way we don't need getters and
     * setters for next, previous and data fields.
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
    
    // this is straight from the textbook - the order of methods will be the same as the
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

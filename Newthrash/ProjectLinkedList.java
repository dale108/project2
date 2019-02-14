import java.util.*;
/**
 * This is a doubly linked, circular list which can hold any type of element. My concept is to 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProjectLinkedList<E> implements List<E> {

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

    public E get(int idx) {
        checkIndex(idx);
        LinkedListNode<E> curr = nodeAt(idx);
        return curr.data;
    }

    public int size(){
        return size;
    }

    public void reset() {
        head.next = end;
        end.next = head;
    }

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

    private LinkedListNode<E> nodeAt(int index) {
        LinkedListNode<E> curr;
        if(index < size/2) {
            curr = head;
            int count = 0;
            // I'm using a while loop here just so the  program is different from source material
            while(count < index + 1) {
                curr = curr.next;
                count++;
            }
            return curr;
        }
        else {
            curr = end;
            int count = size;
            while(count > index) {
                curr = curr.previous;
                count--;
            }
        }
        return curr;
    }

    private boolean checkIndex(int idx) {
        if(idx > size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

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
    // this is straight from the textbook
    private class LinkedIterator implements Iterator<E> {
        private LinkedListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = head.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != end;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            LinkedListNode<E> prev2 = current.previous.previous;
            prev2.next = current;
            current.previous = prev2;
            size--;
            removeOK = false;
        }
    }
}

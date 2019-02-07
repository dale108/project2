
/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Project2LinkedList<T>
{
    
    LinkedListNode head;
    
    
    public Project2LinkedList() {
        head = null;
    }
    
    public Project2LinkedList(LinkedListNode node) {
        head = node;
    }
    
    public Project2LinkedList(T data) {
        head = new LinkedListNode(data);
    }
    
    public void add(Object data) {
        LinkedListNode node = head;
        while(node!= null) {
            node = node.next;
        }
        node.next = new LinkedListNode(data);
    }
    
    public int size() {
        int accum = 0;
        while(head != null) {
            head = head.next;
            accum++;
        }
        System.out.print(accum);
        return accum;
    }
    

    private class LinkedListNode<T> {
        public LinkedListNode next;
        public T data;
        
        // very basic - will probably never need this - only for empty lists
        public LinkedListNode() {
            next = null;
            data = null;
        }
        
        public LinkedListNode(T data) {
            next = null;
            this.data = data ;
        }
        
        // constructor for initial elements
        public LinkedListNode (LinkedListNode next, T data) {
            this.next = next;;
            this.data = data;
        }
        
        // robust constructor
        public LinkedListNode (LinkedListNode next, LinkedListNode prev, T data) {
            this.next = next;
            this.data = data;
        }
        
    }
}

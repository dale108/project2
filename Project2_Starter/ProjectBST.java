
/**
 * Write a description of class ProjectBST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProjectBST<E extends Comparable<E>>{
    private BSTNode<E> overallRoot; 

    /** 
     * Constructors
     */
    /**
     * Constructor 1
     */
    public ProjectBST() {
        overallRoot = null;
    }

    /**
     * Methods
     */

    /**
     * This is the method used for adding all elements to the array - without this, nothing may
     * be added.
     */
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    private BSTNode<E> add(BSTNode<E> root, E value) {
        if(root == null) {
            root = new BSTNode<E>(value);
        }
        else if(root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        }
        else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public boolean contains(E target) {
        return contains(overallRoot, target);
    }

    private boolean contains(BSTNode n, E target) {
        if(n == null) {
            return false;
        }
        else {
            int compare = target.compareTo((E) n.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(n.left, target);
            } else { 
                return contains(n.right, target);
            }
        }
    }

    // prints values in order
    public void print() {
        printInorder(overallRoot);
    }

    private void printInorder(BSTNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    /**
     * This is a custom implementation of the print sideways method we were introduced to in
     * the text. The values in the search tree are ordered based on phoneNumber, so it will
     * print a list ordered by phoen number. 
     */
    public void printGuestSideways() {
        printGuestSideways(overallRoot, 0);
    }

    private void printGuestSideways(BSTNode root, int level) {
        if (root != null) {
            printGuestSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            Guest g = (Guest) root.data;
            String name = g.getPhoneNum();
            System.out.println(name);
            printGuestSideways(root.left, level + 1);
        }
    }

    public void printResSideways() {
        printResSideways(overallRoot, 0);
    }

    private void printResSideways(BSTNode root, int level) {
        if (root != null) {
            printResSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            Reservation r = (Reservation) root.data;
            int num = r.getReservationID();
            System.out.println(num);
            printResSideways(root.left, level + 1);
        }
    }

    

    /**
     * An implementation of encapsulation by nested class. This makes it easy for us to add
     * and remove nodes from the main BST, without having to write get and set methods.
     */
    private class BSTNode<E> {
        public E data;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

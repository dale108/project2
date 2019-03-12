
/**
 * ProjectBST is a custom implementation of a binary search tree for Project 2. It contains
 * standard methods such as add, remove and contains as well as custom methods for use in the
 * program, such as find guest.
 *
 * @author Dale Berg
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
     * Constructor 2
     */
    public ProjectBST(BSTNode root) {
        overallRoot = root;
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

        else if(root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        }

        else {
            root.right = add(root.right, value);
        }

        return root;
    }

    // This is a specialized method for finding a value in the search tree
    public Guest findGuest(String phone) {
        return findGuest(overallRoot, phone);
    }

    private Guest findGuest(BSTNode root, String phone) {
        if(root != null) {
            Guest g = (Guest) root.data;
            if(g.getPhoneNum().compareTo(phone) == 0) {
                return g;
            }
            else if(g.getPhoneNum().compareTo(phone) < 0) {
                return findGuest(root.right, phone);
            }
            else {
                return findGuest(root.left, phone);
            }
        }
        return null;
    }

    /**
     * Remove was the most challenging method to write in the entire program. Essentially,
     * we traverse the tree looking for the value passed as an argument and once we've found it,
     * we traverse the right subtree from the value to be removed until we find the largest
     * value in that subtree (the leftmost leaf). Then we set the data field of the branch we
     * are attempting to remove to the data value of the leaf. If the value to be removed
     * is a leaf, then we can simply set the connection to it to null. I 've written detailed
     * algorithm notes below. 
     */
    public void remove(E value) {
        try {
            remove(overallRoot, value); // recusive call
        }
        catch (IllegalArgumentException e) {
            System.out.println("couldn't find value to remove"); // try/catch so program will not crash
        }
    }

    private BSTNode remove(BSTNode root, E value) throws IllegalArgumentException {
        BSTNode curr = root;
        Guest g = (Guest) curr.data; // need these for comparison
        Guest g2 = (Guest) value;
        if(curr == null) {
            throw new IllegalArgumentException(); // cannot be given a null root. See try catch block above.
        }
        if(g.compareTo(g2) > 0) {
            curr.left = remove(curr.left, value); // main comparison for traversal
        }
        else if(g.compareTo(g2) < 0) {
            curr.right = remove(curr.right, value);
        }
        else {
            if(curr.left == null && curr.right == null) {
                curr = null; // this is leaf case, can just set to null. 
            }
            else if(curr.right == null) {
                curr = curr.left; // go left
            }
            else if(curr.left == null) {
                curr = curr.right; // go right
            }
            else { // at this point we've found our value to be removed
                BSTNode temp = findMinFromRight(curr.right); // custom helper for this method
                curr.data = temp.data;
                curr.right = remove(curr.right, (E) temp.data); // call remove to trim the right we got copied value from.
            }
        }
        return curr;
    }

    /**
     * This is a private helper method for the remove process. 
     */
    private BSTNode findMinFromRight (BSTNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * if the tree contains a value, will return true, otherwise false.
     */
    public boolean contains(E target) {
        return contains(overallRoot, target);
    }

    private boolean contains(BSTNode n, E target) {
        if(n == null) { // this is if we have traversed the entire list and not found value
            return false;
        }
        else {
            int compare = target.compareTo((E) n.data); // this leverages custom compareTo methods
            if (compare == 0) {
                return true;
            } else if (compare < 0) { // control structure to go left or right
                return contains(n.left, target); 
            } else { 
                return contains(n.right, target);
            }
        }
    }

    /**
     * Printing methods.
     */

    /**
     * Prints values in order
     */
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

    public void printPreorder() {
        printPreorder(overallRoot);
    }

    private void printPreorder(BSTNode root) {
        if(root == null) {
            // do nothing, break from rescursion calls.
        }
        else {
            System.out.println(root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printPostorder() {
        printPostorder(overallRoot);
    }

    private void printPostorder(BSTNode root) {
        if(root == null) {

        }
        else {
            printPreorder(root.left);
            printPreorder(root.right);
            System.out.println(root.data);
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

    /**
     * Creates a sideways structural view of the data structure, helpful for testing.
     */
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

    /**
     * An implementation of encapsulation by nested class. This makes it easy for us to add
     * and remove nodes from the main BST, without having to write get and set methods.
     */
    private class BSTNode<E> {
        public E data;
        public BSTNode left;
        public BSTNode right;

        //basic constructor 
        public BSTNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        //robust constructor
        public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}

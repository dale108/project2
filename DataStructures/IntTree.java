import java.util.*;
/**
 * Dale Berg
 * Homework 17
 * 2/11/19
 * 
 * Time Spent: 2 hours
 * 
 * The overall class is transcribed from the textbook - my solutions are at the bottom of the
 * IntTree class. I've included a seperate main class for convinience in testing.
 */
public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // *** Homework code begins here ** //

    // This is my solution for Self-Check problem 13
    public int countBranches() {
        return countBranches(overallRoot);
    }

    private int countBranches(IntTreeNode n) {
        if(n == null || (n.left == null && n.right == null)) {
            return 0;
        }
        return 1 + countBranches(n.left) + countBranches(n.right);
    }

    // This pair of methods is my solution to problem 1
    public int countLeftNodes() {
        return countLeftNodes(overallRoot);
    }

    private int countLeftNodes(IntTreeNode n) {

        if(n == null) {
            return 0;
        }

        else if (n.left != null) {
            return 1+ countLeftNodes(n.left) + countLeftNodes(n.right);
        }
        else {
            return countLeftNodes(n.right);
        }
    }

    // This pair of methods is my solution to problem 7
    public boolean isFull() {
        return isFull(overallRoot);
    }

    private boolean isFull(IntTreeNode n) {
        if(n == null) {
            return true;
        }
        else if((n.right != null && n.left == null) || (n.right == null && n.left != null)) {
            return false;
        }
        return isFull(n.left) && isFull(n.right);
    }

    // below is my solution to problem 13 - an eplaination is in blue comments below
    /**
     * I thought the smartest way to implement copy() was to leverage how the constructor works
     *  - taking a max value and builing a tree from that information. I built a getMax() method
     *  to facilitate this process and I left it public, because it makes sense as a method 
     *  on its own.
     */
    public IntTree copy() {
        return new IntTree(maxValue());
    }

    // see comments for copy()
    public int maxValue() {
        return maxValue(overallRoot);
    }

    private int maxValue(IntTreeNode n) {
        if(n == null) {
            return overallRoot.data;
        }
        else {
            int maxLeft = maxValue(n.left);
            int maxRight = maxValue(n.right);
            return Math.max(Math.max(maxLeft, maxRight), n.data);
        }
    }

    // This is my solution to problem 18
    public ArrayList<Integer> inOrderList() {
        ArrayList<Integer> list= new ArrayList<Integer>();
        return inOrderList(overallRoot, list);
    }

    private  ArrayList<Integer> inOrderList(IntTreeNode n,  ArrayList<Integer> list) {
        if(n == null) {
            return list;
        }
        inOrderList(n.left, list);
        list.add(n.data);
        inOrderList(n.right, list);
        return list;
    }

    // Class for storing a single node of a binary tree of ints
    private class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        // constructs a leaf node with given data
        public IntTreeNode(int data) {
            this(data, null, null);
        }

        // constructs a branch node with given data, left subtree,
        // right subtree
        public IntTreeNode(int data, IntTreeNode left, 
        IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

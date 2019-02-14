
/**
 * Dale Berg
 * Homework 17
 * 2/11/19
 * 
 * Time Spent: 15 minutes
 * 
 * This is a simple driver to test Homework 17 methods.
 */
public class TestMain
{
    public static void main(String[] args) {

        IntTree tree = new IntTree(10);

        tree.printSideways();
        //tree.printPreorder();
        //tree.printPostorder();
        //tree.printInorder();
        System.out.println();

        System.out.print("Number of branches: ");
        System.out.print(tree.countBranches());
        System.out.println();

        System.out.print("Is the Tree full? ");
        System.out.print(tree.isFull());
        System.out.println();

        System.out.print("How many left nodes? ");
        System.out.print(tree.countLeftNodes());
        System.out.println();

        System.out.print("In-order list of values: ");
        System.out.print(tree.inOrderList());
        System.out.println();

        System.out.print("Max value in tree: ");
        System.out.print(tree.maxValue());
        System.out.println();

        System.out.println();
        IntTree tree2 = tree.copy();
        System.out.println("Representattion of copy of tree");
        tree2.printSideways();
    }
}

import java.util.*;
/**
 * Write a description of class TestMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestMain
{  
    public static void main(String[] args) {
        // ProjectLinkedList list = new ProjectLinkedList();
        // list.add("one");
        // list.add("two");
        // list.add("three");
        // list.add("four");
        // list.add("five");
        // System.out.println(list.get(4));
        // System.out.print(list);
        ProjectHashMap map = new ProjectHashMap();
        map.put("Dale", 12);
        map.put("Terry", 90);
        map.put("Dalge", 12);
        map.put("Terry", 90);
        map.put("Harkin", 104);
        //HashSet set = map.getKeySet();
        //int value = (int) map.get("Dale");
        //ProjectLinkedList list = map.getValuesList();
        //System.out.println(list);

        // Guest tests for custom BST
        Guest dale = new Guest("Dale", "Berg");
        Guest razz = new Guest("zill", "Alan");
        Guest bizzy = new Guest("Alan", "Cumming");
        Guest moisey= new Guest("James", "Zepper");
        Guest m= new Guest("nesie", "William");
        Guest isey= new Guest("Jame", "Williams");
        Guest sey= new Guest("Jes", "Zepperdine");

        ProjectBST tree = new ProjectBST();
        tree.add(dale);
        tree.add(razz);
        tree.add(bizzy);
        tree.add(m);
        tree.add(isey);
        tree.add(sey);
        //tree.print();
        //System.out.print(tree.contains(m));
        tree.printGuestSideways();

        // String testing for ProjectBST
        // ProjectBST<String> tree2 = new ProjectBST<String>();
        // tree2.add("A");
        // tree2.add("B");
        // tree2.add("C");
        // tree2.print();
        // System.out.println(tree2.contains("A"));

    }
}

import java.util.*;
import junit.framework.*;
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
        // list.add(2);
        // list.add(3);
        // list.add(3);
        // list.add(4);
        // list.add(1);
        // list.add(4);
        // list.add(5);
        // list.add(8);
        // list.add(8);
        // list.add(8);
        // list.add(9);
        // System.out.println(list);
        // //list.reverse();
        // System.out.println(list);
        // //String s = (String) list.getLastElement();

        // // ProjectHashMap map = new ProjectHashMap();
        // // map.put("Dale", 12);
        // // map.put("Terry", 90);
        // // map.put("Dalge", 12);
        // // map.put("Terry", 90);
        // // map.put("Harkin", 104);
        // // //HashSet set = map.getKeySet();
        // // //int value = (int) map.get("Dale");
        // // //ProjectLinkedList list = map.getValuesList();
        // // //System.out.println(list);

        // // Guest tests for custom BST
        // Guest dale = new Guest("Dale", "Berg","5555555555");
        // Guest razz = new Guest("zill", "Alan","9908008080");
        // Guest bizzy = new Guest("Alan", "Cumming","1231231234");
        // Guest moisey= new Guest("James", "Zepper","9494499494");
        // Guest m= new Guest("nesie", "William","1234567891");
        // Guest isey= new Guest("Jame", "Williams","2223334444");
        // Guest sey= new Guest("Jes", "Zepperdine","9999999999");

        // ProjectBST tree = new ProjectBST();
        // tree.add(dale);
        // tree.add(razz);
        // tree.add(bizzy);
        // tree.add(m);
        // tree.add(isey);
        // tree.add(sey);

        // //tree.remove(bizzy);
        // // //tree.print();
        // // //System.out.print(tree.contains(m));
        // //tree.printGuestSideways();
        // // //tree.remove(bizzy);

        // //find guest test
        // Guest g = tree.findGuest("1231231234");
        // System.out .println(g);

        // String testing for ProjectBST
        // ProjectBST<String> tree2 = new ProjectBST<String>();
        // tree2.add("A");
        // tree2.add("B");
        // tree2.add("C");
        // tree2.print();
        // System.out.println(tree2.contains("A"));

        // Stack tests
        ProjectStack stack = new ProjectStack(10);
        Room r1 = new RegularRoom("1");
        Room r2 = new RegularRoom("2");
        Room r3 = new RegularRoom("3");
        Room r4 = new RegularRoom("4");
        Room room = new RegularRoom("5");
        stack.push(r1);
        stack.push(r2);
        stack.push(r3);
        stack.push(r4);
        while(room != null) {
            room = stack.pop();
            System.out.println(room);
            System.out.println();
        }

    }
}

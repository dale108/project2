import java.util.*;
/**
 * This is where I tested some of the new data structures. The Hotel program is pretty complex
 * at this point, so it's helpful to see simpler representations of some the new processes
 * which are buried in the algorithms.
 * 
 *
 * @author Dale Berg
 */
public class TestMain
{  
    public static void main(String[] args) {
        System.out.println("List demonstration: ");
        ProjectLinkedList list = new ProjectLinkedList();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(9);
        System.out.println(list);
        Integer s = (Integer) list.getLastElement();
        System.out.println(s + " ");
        System.out.println();

        // Showcases the versatility and usefulness of ProjectHashMap
        System.out.println("Map demonstration: ");
        ProjectHashMap map = new ProjectHashMap();
        map.put("Dale", "s");
        map.put("Terry", 90);
        map.put("Dalge", 12);
        map.put("Terry", 90);
        map.put("Harkin", 104);
        HashSet set = map.getKeySet();
        String value = (String) map.get("Dale");
        System.out.print(value);
        ProjectLinkedList list2 = map.getValuesList();
        System.out.println(list2);
        System.out.println();
        System.out.println();

        // Guest tests for custom BST
        System.out.println("BST demonstration: ");
        Guest d = new Guest("Dale", "Berg","5555555555");
        Guest r = new Guest("zill", "Alan","9908008080");
        Guest b = new Guest("Alan", "Cumming","1231231234");
        Guest m = new Guest("James", "Zepper","9494499494");
        Guest n = new Guest("nesie", "William","1234567891");
        Guest j = new Guest("Jame", "Williams","2223334444");
        Guest e = new Guest("Jes", "Zepperdine","9999999999");

        ProjectBST tree = new ProjectBST();
        tree.add(d);
        tree.add(r);
        tree.add(b);
        tree.add(m);
        tree.add(j);
        tree.add(e);

        tree.remove(b);
        tree.print();
        System.out.print(tree.contains(m));
        System.out.println();
        tree.printGuestSideways();
        tree.remove(m);
        System.out.println();
        System.out.println();

        //find guest test
        System.out.println("findGuest() demonstration: ");
        Guest g = tree.findGuest("1231231234");
        System.out.println(g);

        //String testing for ProjectBST
        ProjectBST<String> tree2 = new ProjectBST<String>();
        tree2.add("A");
        tree2.add("B");
        tree2.add("C");
        tree2.print();
        System.out.println(tree2.contains("A"));
        System.out.println();
        System.out.println();

        //Stack tests
        System.out.println("Stack demonstration: ");
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
        while(!stack.isEmpty()) {
        room = stack.pop();
        System.out.println(room);
        System.out.println();
        }

        // int[] arr = {90, 1, 53, 25, 45, 45, 226};
        // mergeR(arr);

        // System.out.println("Sorting demonstration: ");
        // ProjectLinkedList test = new ProjectLinkedList();
        // Room r1 = new RegularRoom("102C");
        // Room r2 = new RegularRoom("102A");
        // Room r3 = new RegularRoom("452P");
        // Room r4 = new RegularRoom("412Z");
        // Room r5 = new RegularRoom("53B");

        // test.add(r1);
        // test.add(r2);
        // test.add(r3);
        // test.add(r4);
        // test.add(r5);

        // Room[] arr = test.toArray();

        // for(int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i].getRoomNumber() + " ");
        // }
    }


}

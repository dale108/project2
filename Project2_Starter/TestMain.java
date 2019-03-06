import java.util.*;
import junit.framework.*;
/**
 * This is where I tested some of the new data structures. The Hotel program is pretty complex
 * at this point, so it's helpful to see simpler representations of the new processes.
 * 
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
        // ProjectStack stack = new ProjectStack(10);
        // Room r1 = new RegularRoom("1");
        // Room r2 = new RegularRoom("2");
        // Room r3 = new RegularRoom("3");
        // Room r4 = new RegularRoom("4");
        // Room room = new RegularRoom("5");
        // stack.push(r1);
        // stack.push(r2);
        // stack.push(r3);
        // stack.push(r4);
        // while(room != null) {
        // room = stack.pop();
        // System.out.println(room);
        // System.out.println();
        // }

        // int[] arr = {90, 1, 53, 25, 45, 45, 226};
        // mergeR(arr);

        ProjectLinkedList test = new ProjectLinkedList();
        Room r1 = new RegularRoom("102C");
        Room r2 = new RegularRoom("102A");
        Room r3 = new RegularRoom("452P");
        Room r4 = new RegularRoom("412Z");
        Room r5 = new RegularRoom("53B");

        test.add(r1);
        test.add(r2);
        test.add(r3);
        test.add(r4);
        test.add(r5);

        Room[] arr = test.toArray();

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getRoomNumber() + " ");
        }
        
        // int[] arr = {9, 112, 4, 5, 7};

        // bubbleSort(arr);

        // for(int i = 0; i <  arr.length; i++) {
            // System.out.print(arr[i] + " ");    
        // }

    }
    public static void mergeR(int[] a) {
        System.out.println("sorting: " + Arrays.toString(a));
        if(a.length > 1) {
            int[] left = Arrays.copyOfRange(a, 0, a.length/2);
            int[] right = Arrays.copyOfRange(a, a.length/2, a.length);

            mergeR(left);
            mergeR(right);

            merge(a, left, right);
        }
    }

    private static void merge(int[] result, int[] left, int[] right) {
        System.out.println("Merging: " + Arrays.toString(left) + Arrays.toString(right));
        int i1 = 0;
        int i2 = 0;

        for(int i = 0; i < result.length; i++) {
            if( i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            }
            else {
                result[i] = right[i2];
                i2++;
            }
        }
    }     

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length - i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}

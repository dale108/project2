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
      map.put("FrankBeans", 104);
      map.put("Dalge", 12);
      map.put("Terery", 90);
      map.put("FranekBeans", 104);
      //HashSet set = map.getKeySet();
      //int value = (int) map.get("Dale");
      ProjectLinkedList list = map.getValuesList();
      System.out.println(list);
      
      
      
    }
}

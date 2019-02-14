
/**
 * Write a description of class TestMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestMain
{
   
    public static void main(String[] args) {
      ProjectLinkedList list = new ProjectLinkedList();
      list.add("one");
      list.add("two");
      list.add("three");
      list.add("four");
      list.add("five");
      System.out.println(list.get(4));
    }
}

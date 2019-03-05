import java.util.Arrays;
/**
 * Custom stack implementation for Project 2. This is utilized in implementing the guest
 * history functionality. Specifically I needed a way to search through the guests
 * 
 * @author Dale Berg
 */
public class ProjectStack
{
    private int currPosition;
    private Room[] elements;
    private final int DEFAULT_SIZE = 100;
     
    public ProjectStack() {
        currPosition = -1;
        elements = new Room[DEFAULT_SIZE];
    }
    
    public ProjectStack(int size) {
        currPosition = -1;
        elements = new Room[size];
    }
    
    public Room pop() {
        if(currPosition >= 0) { // currPosition can be -1, means stack is empty. 
            Room returnRoom = elements[currPosition];
            currPosition = currPosition -1;
            elements[currPosition +1] = null;
            return returnRoom;
        }
        return null;
    }
    
    public void push(Room room) {
        if((currPosition + 1) == elements.length) {
            elements = Arrays.copyOf(elements, elements.length*2);
        }
        currPosition = currPosition + 1;
        elements[currPosition] = room;
    }
    
    public Room peek() {
        if( currPosition == -1) {
            return null;
        }
  
        return elements[currPosition];
    }  
    
    public boolean isEmpty() {
        if(currPosition == -1) {
            return true;
        }
        return false;
    }
}   

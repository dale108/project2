import java.util.Arrays;
/**
 * Custom stack implementation for Project 2. This is utilized in the implementtion of the guest
 * history functionality. Specifically, I needed a way to search through the guests. This Specialized 
 * data structure is only compatible with objects of type Room.
 * 
 * @author Dale Berg
 */
public class ProjectStack
{
    private int currPosition;
    private Room[] elements;
    private final int DEFAULT_SIZE = 100;

    /** 
     * 2 constructors - one for default size. The second constructor is prefereable, as it
     * only utilizes memory which we actually need.
     */
    public ProjectStack() {
        currPosition = -1;
        elements = new Room[DEFAULT_SIZE];
    }

    public ProjectStack(int size) {
        currPosition = -1;
        elements = new Room[size];
    }

    /**
     * METHODS
     */

    /**
     * Standard pop method - works exactly as pop works in the java library stack.
     */
    public Room pop() {
        if(currPosition >= 0) { // currPosition can be -1, means stack is empty. 
            Room returnRoom = elements[currPosition];
            currPosition = currPosition -1;
            elements[currPosition +1] = null;
            return returnRoom;
        }
        return null;
    }

    /**
     * Standard push method - works exactly as pop works in the java library stack.
     */
    public void push(Room room) {
        if((currPosition + 1) == elements.length) {
            // if the addition is going to overrun the array, this will double the size of the array
            elements = Arrays.copyOf(elements, elements.length*2);
        }
        currPosition = currPosition + 1; // adjusts current position
        elements[currPosition] = room;
    }

    /**
     * Standard peek method - works exactly as peek works in the java library stack.
     */    
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

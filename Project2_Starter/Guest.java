import java.util.ArrayList;
import java.lang.IllegalArgumentException;

/**
 * Guest class models a customer of a hotel. The guest is a person with a name and various 
 * personal information. Guests might have discounts applied based on membership to the 
 * hotel or status as a veteran or government employee so we have fields for those data.
 *
 * @author Dale Berg, Nick Coyle, Megan Laine, Steven Liu
 * @version 1/29/2019
 */
public class Guest implements Comparable<Guest>
{
    /* INSTANCE VARIABLES */
    private String firstName;
    private String lastName;
    private String phoneNumber;    
    private boolean isMilitary;
    private boolean isGovernment;
    private boolean isMember;
    ProjectLinkedList<Room> roomHistory;

    /**
     * Guest Constructor 1/1: The full Guest constructor that takes into account all 
     * parameters about a Guest.
     *
     * @param first (String) guest's first name
     * @param last (String) guest's last name
     * @param phoneNum (String) guest's phone number
     * @param partySize (int) how many people in the group, including reserving guest.
     * @param nights (int) how many nights the guest+party will stay at hotel
     * @param isMil (boolean) true if the guest qualifies for military discount
     * @param isGov (boolean) true if the guest qualifies for government discount
     * @param member (boolean) true if the guest qualifies for membership discount
     */
    public Guest( String first, String last, String phoneNum,                    
    boolean isMil, boolean isGov, boolean member )
    {
        setFirstName( first );
        setLastName( last );
        setPhoneNum( phoneNum );        
        setMil( isMil );
        setGovt( isGov );
        setMembership( member );
        roomHistory = new ProjectLinkedList<>();
    }

    public Guest(String first, String last, String phone) {
        this(first,last,phone,false,false,false);
    }

    /* ACCESSOR METHODS */

    /**
     * Method getFirstName returns the guest's first name
     *
     * @return (String) guest's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Method getLastName returns the guest's last name
     *
     * @return (String) guest's last name
     */
    public String getLastName() 
    {
        return lastName;
    }

    /**
     * Method getPhoneNum returns the guest's phone number
     *
     * @return (String) guest's phone number
     */
    public String getPhoneNum() 
    {
        return phoneNumber;
    }

    /**
     * Method getFullName returns guest's first and last name combined in one string
     *
     * @return (String) guest's first and last name combined in one string
     */
    public String getFullName() 
    {
        return firstName + " " + lastName;
    }

    /**
     * Method isMilitary returns true if the guest qualifies for military discount
     *
     * @return true if the guest qualifies for military discount
     */
    public boolean isMilitary() 
    {
        return isMilitary;
    }

    /**
     * Method isGovernment returns true if the guest qualifies for government discount
     *
     * @return true if the guest qualifies for government discount
     */
    public boolean isGovernment() 
    {
        return isGovernment;
    }

    /**
     * Method isMember returns true if the guest qualifies for membership discount
     *
     * @return true if the guest qualifies for membership discount
     */
    public boolean isMember() 
    {
        return isMember;
    }

    /* MUTATOR METHODS */

    /**
     * Method setFirstName sets the guest's first name. An empty string is an invalid name.
     *
     * @param first (String) representing guest's first name
     * @throw IllegalArgumentException if an empty string is passed
     */
    public void setFirstName(String first) 
    {
        if (first.isEmpty())
        {
            throw new IllegalArgumentException("First Name can't be an Empty String");
        }

        firstName = first;
    }

    /**
     * Method setLastName sets the guest's last name. An empty string is an invalid name.
     *
     * @param last (String) representing guest's last name
     * @throw IllegalArgumentException if an empty string is passed
     */
    public void setLastName(String last) 
    {
        if (last.isEmpty())
        {
            throw new IllegalArgumentException("Last Name can't be an Empty String");
        }

        lastName = last;
    }

    /**
     * Method setPhoneNum sets the guest's phone number, if valid. a valid phone number is
     * 10 digits, like 2061234567.
     *
     * @param phoneNum (String) representing guest's phone number 
     */
    public void setPhoneNum(String phoneNum) 
    {
        if(isValidPhone(phoneNum)) {          
            phoneNumber = phoneNum; 
        }
    }

    /**
     * Method isValidPhone checks if the guest's phone number is valid. a valid phone number is
     * 10 digits, like 2061234567.
     *
     * @param phoneNum (String) representing guest's phone number
     * @throw IllegalArgumentException if the phone number does not match a 10digit int.
     */
    public static boolean isValidPhone(String phoneNum) {
        if (!phoneNum.matches("^[0-9]*$"))
        {
            throw new IllegalArgumentException("The phone number entered is not numeric");
        }

        int length = phoneNum.length();
        if (length != 10)
        {
            throw new IllegalArgumentException("The phone number entered must be 10 digits. You entered " + length + " digits");
        }  

        return true;
    }

    /**
     * Method setMil sets the military discount status of the guest.
     *
     * @param m (boolean) representing military discount status of guest.
     */
    public void setMil(boolean m) 
    {
        isMilitary = m;
    }

    /**
     * Method setGovt sets the government discount status of the guest.
     *
     * @param g (boolean) representing government discount status of guest.
     */
    public void setGovt(boolean g) 
    {
        isGovernment = g;
    }

    /**
     * Method setMembership sets the membership discount status of the guest.
     *
     * @param m (boolean) representing membership discount status of guest.
     */
    public void setMembership(boolean m) 
    {
        isMember = m;
    }

    /* OTHER METHODS */

    public void addRoomToHistory(Room room) {
        roomHistory.add(room);
    }
    
    /**
     * Method toString overrides Class Object's toString() method. it returns information 
     * about this Guest, including their name, phone number, party size, nights stayed, 
     * and discount status(es).
     *
     * @return (String) with information about the guest.
     */
    @Override
    public String toString() 
    {
        return this.getFullName() + " , Phone: " + phoneNumber + "\n" +            
        "Military: " + isMilitary + ", " + 
        "Government: " + isGovernment + ", " +
        "Member: " + isMember;        
    }
    

    /**
     * Returns true if this Guest has the same full name and phone number as other Guest.
     * 
     * @param guest (Guest) the other guest to compare with
     * @return equals (boolean) true if the guests have the same full name and phone num.
     */
    public boolean equals(Guest guest)
    {
        boolean equals = false;

        if (this.getFullName().equals(guest.getFullName()) && 
        this.getPhoneNum().equals(guest.getPhoneNum()))
        {
            equals = true;
        }

        return equals;
    }

    /**
     * We need to oraganize Guests so that there is no possibility of duplicates, and the
     * most logical way to accomplish this is by comparing based on phone number.
     */
    @Override
    public int compareTo(Guest other) {
            return this.phoneNumber.compareTo(other.getPhoneNum());
    }
        
    /**
     * This method utilizes a custom stack class to ensure the room returned to main when utilizing
     * the express check-in function is an available room. A stack is the perfect data structure
     * to use in this case, because of it's last in, first out dynamic.
     */
    public Room getLastRoom() {
        ProjectStack stack = new ProjectStack(roomHistory.size());
        for(Room room: roomHistory) {
            stack.push(room);
        }
        while(!stack.isEmpty()) {
            Room room = stack.pop();
            if(room.isAvailable()){
                return room;
            }
        }
        return null;
    }
    
    /**
     * This is a test method I've chosen to leave in for convinience. It's plausibe that a
     * client might want to see the room history of a certain guest.
     */
    public void printRoomHistory() {
        System.out.println(roomHistory.size());
        for( Room room : roomHistory) {
            System.out.println(room);
        }
    }
}
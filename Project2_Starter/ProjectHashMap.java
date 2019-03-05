import java.util.*;
/**
 * I needed to make a map which would make sense for either Rooms or Guests. This map would
 * work with generic data types. I opted to make it as specialized as possible, so
 * that I can leverage the fact that it is custom in implementation 
 */
public class ProjectHashMap
{
    ProjectEntry[] buckets; // This is the foundation of the hash table.

    public ProjectHashMap() {
        buckets = new ProjectEntry[100];
    }

    public void put(String key, Object val) {
        ProjectEntry<String, Object> addEntry = new ProjectEntry<>(key, val); // this is the entry to be added

        int placementBucket = determineBucket(key); // this is how we find our bucket for the new entry

        ProjectEntry<String, Object> curr = buckets[placementBucket];
        
        if(curr == null) {
            buckets[placementBucket] = addEntry; // if bucket empty, we can add now
        }
        else {
            ProjectEntry<String, Object> prev = null; // need to declare outside loop
            while(curr != null) {
                if(curr.key.equals(key)) {
                    addEntry.next = curr.next;
                    prev.next = addEntry;
                    return;
                }
                prev = curr;
                curr = curr.next; 
            }
            prev.next = addEntry;
        }
    }

    public Object get(String key) {
        int currentBucket = determineBucket(key); // find the bucket this value might be in
        if(buckets[currentBucket] == null) { // if the bucket is empty, no value
            return null;
        }
        else {
            ProjectEntry<String, Object> curr = buckets[currentBucket]; // do a linked traversal
            while(curr != null) { // while we have values in the chain
                if(curr.key.equals(key)) { // check for when we find the value
                    return curr.value;
                }
                curr = curr.next;
            }
            return null; // if we get here the value does not exist in the map
        }
    }

    public ProjectEntry<String, Object> remove(String key) {
        int currentBucket = determineBucket(key); // finds correct bucket to check
        if(buckets[currentBucket] == null) { // if the bucket is null, no values
            return null;
        }
        else {
            ProjectEntry<String, Object> previous = null; 
            ProjectEntry<String, Object> targetEntry = null;
            ProjectEntry<String, Object> current = buckets[currentBucket];
            while(current != null) {
                if(current.key.equals(key)) {
                    targetEntry = new ProjectEntry<String, Object>(current.key, current.value);
                    if(previous == null) { // this is checking if we are at the very start of the array
                        buckets[currentBucket] = buckets[currentBucket].next;
                        return targetEntry;
                    }
                    else { // If we get here it means entry is not the first in a chain
                        previous.next = current.next;
                        return targetEntry;
                    }
                }
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    //Hopefully similar to Java's keyset method
    public HashSet getKeySet() {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < buckets.length; i++) { // iterates through each bucket
            ProjectEntry curr = buckets[i]; // curr is at head of chain
            while(curr != null) {
                set.add((String) curr.key);
                curr = curr.next;
            }
        }
        return set;
    }
    
    
    public ProjectLinkedList getValuesList() {
        ProjectLinkedList<Object> returnList = new ProjectLinkedList();
        for(int i = 0; i < buckets.length; i++) {
            ProjectEntry curr = buckets[i];
            while(curr != null) {
                returnList.add(curr.value);
                curr = curr.next;
            }   
        }
        return returnList;
    }
    
    private int determineBucket(String key) {
        // we don't want a huge array because our lists probably won't be very big - if we need
        // to scale this for any reason, we could increase the size of the array and take the 
        // mod of ten 2 times.
        int returnValue = key.hashCode() % 10;
        return Math.abs(returnValue);
    }

    /**
     * We can keep this class general.
     */
    private class ProjectEntry<K, V> 
    {
        public K key;
        public V value;
        ProjectEntry<String, Object>  next;

        public ProjectEntry(K key, V val) {
            value = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return "{ key = " + key + "value = " + value + " }";
        }
    }
}

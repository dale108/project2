/**
 * This is a list interface implementation. Really, this only exists because we want
 * ProjectLinkedList to both implement list and extend iterable - this requires a second class. 
 * 
 */
public interface List<E> extends Iterable<E> {
    public int size();

    public E get(int index);

    public int indexOf(E value);

    public boolean isEmpty();

    public boolean contains(E value);

    public void add(E value);

    public void add(int index, E value);

    public void remove(int index);

    public void set(int index, E value);

    public void reset(); // need reset for doubly linke dlists.
}
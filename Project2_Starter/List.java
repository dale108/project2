
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

    public void reset();
}
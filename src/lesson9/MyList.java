package lesson9;

public interface MyList {
    int size();

    boolean isEmpty();

    boolean contains(Integer item);

    Integer[] toArray();

    boolean add(Integer item);

    boolean remove(Integer item);

    boolean addAll(Integer[] coll);

    void clear();

    void remove(Object o);

    void add(Object o);

    Object set(int index, Integer item);

    void add(int index, Object o);

    Object remove(int index);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    boolean removeAll(Integer[] coll);

    String toString();
}


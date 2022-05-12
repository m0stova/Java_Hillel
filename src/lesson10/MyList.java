package lesson10;

public interface MyList {

    int size();

    boolean isEmpty();

    boolean contains(Integer item);

    Integer[] toArray();

    boolean add(Integer item);

    boolean remove(Integer item);

    boolean addAll(Integer[] coll);

    boolean addAll(int index, Integer[] coll);

    void clear();

    Integer get(int index);

    Integer set(int index, Integer item);

    void add(int index, Integer item);

    Integer remove(int index);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    boolean removeAll(Integer[] coll);

}


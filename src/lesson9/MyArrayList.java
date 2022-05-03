package lesson9;


public class MyArrayList implements MyList {
    private final int DEFAULT_CAPACITY = 16;
    private Object[] myList = new Object[DEFAULT_CAPACITY];
    private int size;
    private String name;

    public MyArrayList(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) >= -1;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[0];
    }

    @Override
    public boolean add(Integer item) {
        increasingTheArray();
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == null) {
                myList[i] = item;
                break;
            }
        }
        size++;
        return false;
    }

    @Override
    public boolean remove(Integer item) {
        boolean findItem = false;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] != null && myList[i].equals(item)) {
                findItem = true;
                myList[i] = null;
                for (int j = i; j < myList.length - 1; j++) {
                    Integer changeItem = (Integer) myList[j];
                    myList[j] = myList[j + 1];
                    myList[j + 1] = changeItem;
                }
                size--;
                break;
            }
        }
        return findItem;
    }

    @Override
    public boolean addAll(Integer[] coll) {
        for (Integer item : coll) {
            add(item);
        }
        return coll.length > 0;
    }


    @Override
    public void clear() {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] != null) {
                myList[i] = null;
                size--;
            }
        }
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == o) {
                myList[i] = null;
                size--;
                return;
            }
        }
    }

    @Override
    public void add(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == null) {
                myList[i] = o;
                size++;
                break;
            }
        }
        if (size > myList.length - 1) {
            increasingTheArray();
        }
    }

    @Override
    public Object set(int index, Integer item) {
        checkOfIndex(index);
        Object returnElement = myList[index];
        myList[index] = item;
        return returnElement;
    }

    @Override
    public void add(int index, Object o) {
        myList[index] = o;
        size++;
        if (size > myList.length - 1) {
            increasingTheArray();
        }
    }

    @Override
    public Object remove(int index) {
        checkOfIndex(index);
        Object returnItem = set(index, null);
        for (int i = index; i < myList.length - 1; i++) {
            Object changeItem = myList[i];
            myList[i] = myList[i + 1];
            myList[i + 1] = changeItem;
        }
        size--;
        return returnItem;
    }

    @Override
    public int indexOf(Integer item) {
        int index = -1;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] != null && myList[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = -1;
        for (int i = myList.length - 1; i >= 0; i--) {
            if (myList[i] != null && myList[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean removeAll(Integer[] coll) {
        for (Integer integer : coll) {
            for (int j = 0; j < myList.length; j++) {
                if (integer.equals(myList[j])) {
                    remove(myList[j]);
                    j--;
                }
            }
        }
        return coll.length > 0;
    }


    private void increasingTheArray() {
        Object[] newArray = new Object[myList.length * 2];
        System.arraycopy(myList, 0, newArray, 0, size);
        myList = newArray;

    }

    private void checkOfIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Your index does not meet the allowable rules");
        }
    }


}


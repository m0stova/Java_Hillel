package lesson10;

public class MyLinkedList implements MyList {

    public Node firstN;
    public Node lastN;
    int size;


    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node temp = firstN;
        int i = 0;
        while (i < index) {
            temp = temp.getNext();
            i++;
        }
        return temp;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean contains(Integer item) {
        Node temp = firstN;
        for (int i = 0; i < size; i++) {
            if (item.equals(temp.item)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = getNode(i).getItem();
        }
        return array;
    }

    @Override
    public boolean add(Integer item) {
        int number = item;
        Node temp = firstN;
        if (firstN == null) {
            Node newNode = new Node(number, null, null);
            firstN = lastN = newNode;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node newNode = new Node(number, null, temp);
            temp.setNext(newNode);
            lastN = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Integer item) {
        Node temp = firstN;
        while (temp.getNext() != null) {
            if (item.equals(temp.item)) {
                Node prev = temp.getPrev();
                Node next = temp.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                size--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean addAll(Integer[] coll) {
        return false;
    }

    @Override
    public boolean addAll(int index, Integer[] coll) {
        return false;
    }

    @Override
    public void clear() {
        Node temp = firstN;
        while (temp != null) {
            Node next = temp.getNext();
            temp.item = null;
            temp.next = null;
            temp.prev = null;
            temp = next;
        }
        firstN = lastN = null;
        size = 0;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer item) {
        return null;
    }


    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Node temp = getNode(index);
        Node prev = temp.getPrev();
        Node next = temp.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return temp.getItem();
    }

    @Override
    public int indexOf(Integer item) {
        int index = 0;
        Node someNode = firstN;
        while (someNode.getNext() != null) {
            if (item.equals(someNode.item)) {
                return index;
            }
            someNode = someNode.getNext();
            index++;
        }
        if (item.equals(lastN.item)) return index;
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = --size;
        Node someNode = lastN;
        while (someNode.getPrev() != null) {
            if (item.equals(someNode.item)) {
                return index;
            }
            someNode = someNode.getPrev();
            index--;
        }
        if (item.equals(firstN.item)) return index;
        return -1;
    }

    @Override
    public boolean removeAll(Integer[] coll) {
        return false;
    }


    @Override
    public void add(int index, Integer item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (firstN == null || index == size) {
            add(item);
        } else {
            Node temp = getNode(index);
            Node prev = temp.getPrev();
            Node newNode = new Node(item, temp, prev);
            temp.setPrev(newNode);
            if (prev != null) {
                prev.setNext(newNode);
            } else firstN = newNode;
            size++;
        }
    }

    private static class Node {
        Integer item;
        Node next;
        Node prev;


        public Node(int item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

}

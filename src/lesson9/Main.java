package lesson9;

import java.util.ArrayList;
import java.util.ListIterator;


public class Main {

    public static void main(String[] args) {
        ArrayList<MyArrayList> flowers = new ArrayList<>();
        System.out.println("The original size of the list is now: " + flowers.size());
        System.out.println("The size of yours flowers list is empty now: " + flowers.isEmpty());


        flowers.add(new MyArrayList("daisy"));
        flowers.add(new MyArrayList("rose"));
        flowers.add(new MyArrayList("iris"));
        flowers.add(new MyArrayList("sunflower"));
        flowers.add(new MyArrayList("tulip"));

        System.out.println("Your plants list now: " + flowers);

        flowers.clear();
        System.out.println("Your list after clear-function: " + flowers);

        flowers.add(new MyArrayList("narcissus"));
        flowers.add(new MyArrayList("orchid"));
        flowers.add(new MyArrayList("poppy"));
        flowers.add(new MyArrayList("iris"));
        flowers.add(new MyArrayList("sunflower"));
        flowers.add(new MyArrayList("peony"));
        System.out.println("Your new list" + flowers);
        flowers.remove(2);
        System.out.println("Your list after deleting-function " + flowers);


        ListIterator<MyArrayList> listIterator = flowers.listIterator();
        System.out.println("\nThe iterator values"
                + " of list are: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        
    }
}


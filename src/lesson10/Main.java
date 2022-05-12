package lesson10;


import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> fibonacci = new LinkedList<>();
        System.out.println("The original size of the list is now: " + fibonacci.size());
        System.out.println("The size of your list is empty now: " + fibonacci.isEmpty());
        fibonacci.addLast(1);
        fibonacci.addLast(1);
        fibonacci.addLast(2);
        fibonacci.addLast(3);
        fibonacci.addLast(5);
        fibonacci.addLast(8);
        fibonacci.addLast(13);
        fibonacci.addLast(21);

        System.out.println("Your list now: ");
        System.out.println(fibonacci);

        System.out.println("Lets add new number!");
        fibonacci.addLast(34);
        System.out.println("Your updated fibonacci list is so now: ");
        fibonacci.forEach(System.out::println);

        System.out.println("The index of number 21 is: " + fibonacci.indexOf(21));
        System.out.println("Would you like to clear your list?");
        fibonacci.clear();
        System.out.println("Lists update: " + fibonacci);


    }
}

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        /*
         * create arraylist and linked list of elements 4 5 8 7 9 6 3 2
         */


        //        ArrayList
        List<Integer> aList = new ArrayList<>();
        aList.add(4);
        aList.add(5);
        aList.add(8);
        aList.add(7);
        aList.add(9);
        aList.add(6);
        aList.add(3);
        aList.add(2);

        aList.remove(5);
        aList.set(2,89);

        System.out.println("Array List elements");
        Iterator<Integer> iterator = aList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //        LinkedList
        List<Integer> lList = new LinkedList<>();
        lList.add(4);
        lList.add(5);
        lList.add(8);
        lList.add(7);
        lList.add(9);
        lList.add(6);
        lList.add(3);
        lList.add(2);

        System.out.println("Linked List elements");
        Iterator<Integer> iterator2 = lList.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("Linked List elements with list iteratorforward");
        ListIterator<Integer> iterator3 = lList.listIterator();

        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

        System.out.println("Linked List elements with list iteratorback");

        while (iterator3.hasPrevious()) {
            System.out.println(iterator3.previous());
        }
    }
}

package assignment1;

import java.util.PriorityQueue;

public class Exercise10 {

    public static void main(String[] args) {
//        Create two priority queues,
//        {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and
//        {"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their
//        union, difference, and intersection.

        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>();

        priorityQueue1.offer("George");
        priorityQueue1.offer("Jim");
        priorityQueue1.offer("John");
        priorityQueue1.offer("Blake");
        priorityQueue1.offer("Kevin");
        priorityQueue1.offer("Michael");

        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>();

        priorityQueue2.offer("George");
        priorityQueue2.offer("Katie");
        priorityQueue2.offer("Kevin");
        priorityQueue2.offer("Michelle");
        priorityQueue2.offer("Ryan");

        PriorityQueue<String> unionPriorityQueue = union(priorityQueue1, priorityQueue2);
        PriorityQueue<String> intersectionPriorityQueue = intersection(priorityQueue1, priorityQueue2);
        PriorityQueue<String> differencePriorityQueue = difference(priorityQueue1, priorityQueue2);

        System.out.println("*****************UNION******************");
        print(unionPriorityQueue);
        System.out.println("*****************INTERSECTION******************");
        print(intersectionPriorityQueue);
        System.out.println("*****************DIFFERENCE******************");
        print(differencePriorityQueue);
    }

    public static PriorityQueue<String> union(PriorityQueue<String> priorityQueue1, PriorityQueue<String> priorityQueue2) {
        PriorityQueue<String> union = new PriorityQueue<>();
        union.addAll(priorityQueue1);
        for (String ele : priorityQueue2) {
            if (!union.contains(ele)) {
                union.offer(ele);
            }
        }
        return union;
    }

    public static PriorityQueue<String> intersection(PriorityQueue<String> priorityQueue1, PriorityQueue<String> priorityQueue2) {
        PriorityQueue<String> intersection = new PriorityQueue<>();
        for (String ele : priorityQueue2) {
            if (priorityQueue1.contains(ele)) {
                intersection.offer(ele);
            }
        }
        return intersection;
    }

    public static PriorityQueue<String> difference(PriorityQueue<String> priorityQueue1, PriorityQueue<String> priorityQueue2) {
        PriorityQueue<String> intersection = intersection(priorityQueue1, priorityQueue2);
        PriorityQueue<String> difference = new PriorityQueue<>();
        for (String ele : priorityQueue1) {
            if (!intersection.contains(ele)) {
                difference.offer(ele);
            }
        }

        for (String ele : priorityQueue2) {
            if (!intersection.contains(ele)) {
                difference.offer(ele);
            }
        }
        return difference;
    }

    public static void print(PriorityQueue<String> queue) {
        for (String ele : queue) {
            System.out.print(ele + " , ");
        }
        System.out.println();
    }

}

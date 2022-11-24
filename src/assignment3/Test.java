package assignment3;

import java.util.Comparator;

public class Test {

    public static void main(String[] args) {

        GeometricObject[] list = {new Circle(5),
                new Rectangle(4, 5),
                new Circle(5.5),
                new Rectangle(2.4, 5),
                new Circle(0.5),
                new Rectangle(4, 65),
                new Circle(4.5),
                new Rectangle(4.4, 1),
                new Circle(6.5),
                new Rectangle(4, 5)};

        selectionSort(list, new GeometricObjectComparator());

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
        }
    }


    public static <GeometricObject> void selectionSort(GeometricObject[] list,
                                                       Comparator<? super GeometricObject> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            GeometricObject currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(currentMin, list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }

    }
}

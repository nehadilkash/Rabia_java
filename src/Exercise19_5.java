public class Exercise19_5 {

    public static void main(String[] args) {

        Integer[] array = {5, 6, 2, 4, 3, 5, 9};
        System.out.println("max element " + max(array));

        Double[] array2 = {5.0, 6.0, 2.0, 4.0, 3.0, 5.0, 9.0};
        System.out.println("max element " + max(array2));

        Long[] array3 = {5L, 6L, 2L, 4L, 3L, 5L, 9L};
        System.out.println("max element " + max(array3));

    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }
}

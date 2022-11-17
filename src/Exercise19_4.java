public class Exercise19_4 {
    public static void main(String[] args) {

        Integer[] array = {5, 6, 2, 4, 3, 5, 9};
        System.out.println("search key 4 " + linearSearch(array, 4));
        System.out.println("search key 8 " + linearSearch(array, 8));

        Long[] array3 = {5L, 6L, 2L, 4L, 3L, 5L, 9L};
        System.out.println("search key 4 " + linearSearch(array, 4L));
        System.out.println("search key 8 " + linearSearch(array, 8L));

        Double[] array2 = {5.0, 6.0, 2.0, 4.0, 3.0, 5.0, 9.0};
        System.out.println("search key 4.0 " + linearSearch(array2, 4.0));
        System.out.println("search key 8.0 " + linearSearch(array2, 8.0));

    }

    public static <E extends Comparable> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }


}

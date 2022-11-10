public class Exercise18_13 {

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 1, 2, 8, 4};
        System.out.println(getMax(a, 0));
    }

    public static int getMax(int[] a, int i) {
        if (i < a.length-1) {
            return Math.max(getMax(a, i + 1),a[i]);
        } else {
           return  Math.max(a[i],a[i-1]);
        }
    }
}


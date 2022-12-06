import java.util.List;

public class CommonManager {

    public static <T> void printList(List<T> t) {
        for (T item : t
        ) {
            System.out.println(item);
        }
    }
}

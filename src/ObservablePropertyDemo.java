import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {
    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(ov -> {
                    System.out.println("The new value is " +
                            balance.doubleValue());
                });

        balance.set(4.5);
        balance.set(5.5);

    }
}
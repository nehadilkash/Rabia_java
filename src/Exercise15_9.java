import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_9 extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Pane pane = new Pane();

        // Create a polyline
        Polyline polyline = new Polyline(new Double(100.0), new Double(100.0));
        polyline.setFill(Color.WHITE);
        polyline.setStroke(Color.BLACK);
        pane.getChildren().add(polyline);
        ObservableList<Double> list = polyline.getPoints();

        // Create and register handler
        pane.setOnKeyPressed(e -> {
            double x = 0, y = 0;
            double length = 10;
            switch (e.getCode()) {
                case DOWN: x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) + length; break;
                case UP: x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) - length; break;
                case RIGHT: x = list.get(list.size() - 2) + length;
                    y = list.get(list.size() - 1); break;
                case LEFT: x = list.get(list.size() - 2) - length;
                    y = list.get(list.size() - 1); break;

            }
            list.add(x);
            list.add(y);
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("KeyEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        pane.requestFocus(); // text is focused to receive key input
    }

}
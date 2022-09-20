import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShowRectangolid extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Rectangle r1 = new Rectangle(25, 50, 60, 30);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);

        r1.heightProperty().bind(pane.heightProperty().divide(2));
        r1.widthProperty().bind(pane.widthProperty().divide(2));
        pane.getChildren().add(r1);
        Scene scene = new Scene(pane, 250, 150);
        Rectangle r2 = new Rectangle(50, 25, 60, 30);
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        r2.heightProperty().bind(pane.heightProperty().divide(2));
        r2.widthProperty().bind(pane.widthProperty().divide(2));
        pane.getChildren().add(r2);

        Line line1 = new Line(50, 25, 25, 50);
        pane.getChildren().add(line1);

        Line line2 = new Line(50, 25 + r1.getHeight(), 25, 50 + r2.getHeight());
        pane.getChildren().add(line2);
        line2.startYProperty().bind(pane.heightProperty().divide(2).add(25));
        line2.endYProperty().bind(pane.heightProperty().divide(2).add(50));

        Line line3 = new Line(50 + r1.getWidth(), 25, 25 + r1.getWidth(), 50);
        pane.getChildren().add(line3);
        line3.startXProperty().bind(pane.widthProperty().divide(2).add(50));
        line3.endXProperty().bind(pane.widthProperty().divide(2).add(25));

        Line line4 = new Line(50 + r1.getWidth(), 25 + r1.getHeight(), 25 + r1.getWidth(), 50 + r1.getHeight());
        pane.getChildren().add(line4);
        line4.startXProperty().bind(pane.widthProperty().divide(2).add(50));
        line4.startYProperty().bind(pane.heightProperty().divide(2).add(25));
        line4.endXProperty().bind(pane.widthProperty().divide(2).add(25));
        line4.endYProperty().bind(pane.heightProperty().divide(2).add(50));


        Rectangle r3 = new Rectangle(50, 50, 55, 55);
        r3.setFill(Color.WHITE);
        r3.setStroke(Color.BLACK);
        pane.getChildren().add(r3);
        r3.heightProperty().bind(pane.heightProperty().divide(2).subtract(25));
        r3.widthProperty().bind(pane.widthProperty().divide(2).subtract(25));

        primaryStage.setTitle("ShowRectangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }
}

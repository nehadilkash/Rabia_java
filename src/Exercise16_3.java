import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise16_3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        VBox vBox = new VBox(5.5);
        vBox.setPadding(new Insets(5, 5, 5, 5));

        vBox.setAlignment(Pos.CENTER);

        Circle cred = new Circle(10);
        cred.setFill(Color.WHITE);
        cred.setStroke(Color.BLACK);

        Circle cyellow = new Circle(10);
        cyellow.setFill(Color.WHITE);
        cyellow.setStroke(Color.BLACK);

        Circle cgreen = new Circle(10);
        cgreen.setFill(Color.WHITE);
        cgreen.setStroke(Color.BLACK);

        vBox.getChildren().addAll(cred, cyellow, cgreen);
        vBox.setStyle("-fx-border-color: black");

        pane.setCenter(vBox);

        HBox hBox = new HBox(5.5);
        hBox.setPadding(new Insets(5, 5, 5, 5));

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        hBox.getChildren().addAll(rbRed, rbGreen, rbYellow);
        pane.setBottom(hBox);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbYellow.setToggleGroup(group);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                cred.setFill(Color.RED);
                cyellow.setFill(Color.WHITE);
                cgreen.setFill(Color.WHITE);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                cred.setFill(Color.WHITE);
                cyellow.setFill(Color.YELLOW);
                cgreen.setFill(Color.WHITE);

            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                cred.setFill(Color.WHITE);
                cyellow.setFill(Color.WHITE);
                cgreen.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Traffic Lights");
        primaryStage.show();
    }

}



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Label mileLabel = new Label("Mile");
        mileLabel.setStyle("-fx-border-color: black; -fx-border-width: 2");

        TextField mileTextField = new TextField();
        mileTextField.setAlignment(Pos.BOTTOM_RIGHT);

        Label kilometerLabel = new Label("Kilometer");
        kilometerLabel.setStyle("-fx-border-color: black; -fx-border-width: 2");

        TextField kilometerTextField = new TextField();
        kilometerTextField.setAlignment(Pos.BOTTOM_RIGHT);

        mileTextField.setOnAction(e -> kilometerTextField.setText(convertToKilometer(mileTextField.getText())));

        kilometerTextField.setOnAction(e -> mileTextField.setText(convertToMiles(kilometerTextField.getText())));

        pane.add(mileLabel, 0, 0);
        pane.add(mileTextField, 1, 0);
        pane.add(kilometerLabel, 0, 1);
        pane.add(kilometerTextField, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("MILES & KILOMETERS");
        primaryStage.show();
    }

    public static String convertToKilometer(String text) {

        Double kilometers = new Double(text)*1.60934;
        return kilometers.toString();
    }

    public static String convertToMiles(String text) {

        Double miles = new Double(text)*0.621371;
        return miles.toString();
    }
}

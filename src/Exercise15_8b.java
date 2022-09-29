import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_8b extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Pane pane = new Pane();

        Text text = new Text(20, 20, "");
        pane.getChildren().addAll(text);

//        when a mouse is pressed a event e happens
        pane.setOnMousePressed(e -> {

//          text is node (a text box)
//          e.getX gives the x cordinate where event happened (mouse press)
//          e.gety gives the y cordinate where event happened (mouse press)

//          set value in text box as X and Y cordinate where mouse pressed
            text.setText("(" + e.getX() + "," + e.getY() + ")");
//          change the textbox location to where mouse preesed by setting and x and y of
//          textbox to x and y of event happened.
            text.setX(e.getX());
            text.setY(e.getY());

        });

        pane.setOnMouseReleased(e -> {
            text.setText("");
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("MouseEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

}
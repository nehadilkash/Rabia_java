import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowText extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text(100, 100, "Neha Dilkash");
        StackPane pane = new StackPane();
        pane.getChildren().add(text);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

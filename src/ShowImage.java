import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("image/tree-736885__480.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        Pane pane = new HBox();
        pane.getChildren().add(imageView);
        pane.setPadding(new Insets(2,2,4,4));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("show Image");
        primaryStage.setResizable(true);
    }
}

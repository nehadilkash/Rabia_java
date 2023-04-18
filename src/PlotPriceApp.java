import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlotPriceApp extends Application {
    private static final String DATA_FILE = "src/CompanyX.dat";
    private static final int IMAGE_WIDTH = 600;
    private static final int IMAGE_HEIGHT = 550;

    private ArrayList<Boundary> boundaries;
    private double price;
    private double pricePerSqFt;
    private Label priceLabel;
    private Label pricePerSqFtLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(IMAGE_WIDTH, IMAGE_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane();
        root.setTop(canvas);
        priceLabel = new Label();
        pricePerSqFtLabel = new Label();
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(priceLabel, pricePerSqFtLabel);
        root.setBottom(vBox);
        Scene scene = new Scene(root, IMAGE_WIDTH, IMAGE_HEIGHT + 100);
        primaryStage.setTitle("Plot Price App");
        primaryStage.setScene(scene);
        primaryStage.show();
        canvas.setOnMouseMoved(event -> updatePrice(event.getX(), event.getY()));
        loadBoundaries();
        drawImage(gc);
    }

    private void loadBoundaries() {
        boundaries = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Double> xPoints = new ArrayList<>();
                ArrayList<Double> yPoints = new ArrayList<>();
                String[] points = line.split("-");
                double price = Double.parseDouble(points[1]);
                String[] cords = points[0].split(",");
                for (String str : cords) {
                    String[] splitCords = str.split(" ");
                    xPoints.add(Double.valueOf(splitCords[0]));
                    yPoints.add(Double.valueOf(splitCords[1]));
                }

                Boundary boundary = new Boundary(xPoints, yPoints, price);

                boundaries.add(boundary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePrice(double mouseX, double mouseY) {


        price = 0;
        pricePerSqFt = 0;
        boolean insideBoundary = false;
        for (Boundary boundary : boundaries) {

            if (boundary.contains(mouseX, mouseY)) {
                insideBoundary = true;
                price = boundary.getPrice();
                pricePerSqFt = price / boundary.getArea();
                break;
            }
        }
        if (!insideBoundary) {
            priceLabel.setText("");
            pricePerSqFtLabel.setText("");
        } else {
            priceLabel.setText("Price: $" + price / 1000 + "k");
            pricePerSqFtLabel.setText(String.format("%s%.2f", "Price per Sq Ft: $", pricePerSqFt));
        }
    }

    private void drawImage(GraphicsContext gc) {
        // Load and display image
        String imagePath = getClass().getResource("image.jpg").toExternalForm();
        gc.drawImage(new javafx.scene.image.Image(imagePath), 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}


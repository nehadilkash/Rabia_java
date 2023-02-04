package assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends Application {
    DataOutputStream dataOutputStreamToServer;//CREATE STREAM TO WRITE DATA TO SERVER
    DataInputStream dataInputStreamfromServer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane paneForTextField = new GridPane();
        paneForTextField.setVgap(5);
        paneForTextField.setHgap(5);
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color : green ");


        TextField weightTf = new TextField();
        TextField heightTf = new TextField();

        Button submitButton = new Button("Submit");
        paneForTextField.add(new Label("Weight in pounds"), 0, 0);
        paneForTextField.add(new Label("Height in inches"), 0, 1);
        paneForTextField.add(weightTf, 1, 0);
        paneForTextField.add(heightTf, 1, 1);
        paneForTextField.add(submitButton, 2, 1);


        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Exercise33_02Client");
        primaryStage.setScene(scene);
        primaryStage.show();


        try {
            Socket socket = new Socket("localhost", 8000);
            dataOutputStreamToServer = new DataOutputStream(socket.getOutputStream());
            dataInputStreamfromServer = new DataInputStream(socket.getInputStream());

        } catch (Exception e) {
            System.out.println("error occurred while creating client socket");
        }

        submitButton.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(weightTf.getText().trim());
                double height = Double.parseDouble(heightTf.getText().trim());
                dataOutputStreamToServer.writeDouble(weight);
                dataOutputStreamToServer.writeDouble(height);
                dataOutputStreamToServer.flush();
                Platform.runLater(() -> {
                    ta.appendText("Weight : " + weight + "\n");
                    ta.appendText("Height : " + height + "\n");
                });
                String bmi = dataInputStreamfromServer.readUTF();

                Platform.runLater(() -> {
                    ta.appendText(bmi + "\n");
                });

            } catch (Exception exc) {
                System.out.println("Error occurred while writing data to server");
            }
        });


    }
}
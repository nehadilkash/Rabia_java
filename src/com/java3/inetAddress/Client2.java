package com.java3.inetAddress;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client2 extends Application {
    DataOutputStream dataOutputStreamToServer;//CREATE STREAM TO WRITE DATA TO SERVER
    DataInputStream dataInputStreamfromServer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color : green ");
        paneForTextField.setLeft(new Label("Enter a radius"));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client2");
        primaryStage.setScene(scene);
        primaryStage.show();


        try {
            Socket socket = new Socket("localhost", 8000);
            dataOutputStreamToServer = new DataOutputStream(socket.getOutputStream());
            dataInputStreamfromServer = new DataInputStream(socket.getInputStream());

        } catch (Exception e) {
            System.out.println("error occurred while creating client socket");
        }

        tf.setOnAction(e -> {
            try {
                double radius = Double.parseDouble(tf.getText().trim());
                dataOutputStreamToServer.writeDouble(radius);
                dataOutputStreamToServer.flush();

                double area = dataInputStreamfromServer.readDouble();

                Platform.runLater(() -> {
                    ta.appendText("Area calculated for radius :  " + radius + " is " + area + "\n");
                });

            } catch (Exception exc) {
                System.out.println("Error occurred while writing data to server");
            }
        });


    }
}
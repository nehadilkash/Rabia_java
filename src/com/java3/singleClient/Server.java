package com.java3.singleClient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread thread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);

                Platform.runLater(() -> {
                    ta.appendText("Server Started at " + new Date() + "\n");
                });


                while (true) {
                    Socket socket = serverSocket.accept();
                    DataInputStream dataInputStreamFromClient = new DataInputStream(socket.getInputStream());
                    DataOutputStream dataOutputStreamToClient = new DataOutputStream(socket.getOutputStream());
                    double radius = dataInputStreamFromClient.readDouble();
                    Platform.runLater(() -> {
                        ta.appendText("Received radius from Client : " + radius + "\n");
                    });
                    double area = Math.PI * radius * radius;

                    Platform.runLater(() -> {
                        ta.appendText("Area calculated  :  " + area + "\n");
                    });
                    dataOutputStreamToClient.writeDouble(area);
                }


            } catch (Exception e) {
                System.err.println("Exception occurred");
            }


        });

        thread.start();

    }
}
package com.java3.google;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.Socket;

public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Connect to Google");
        primaryStage.setScene(scene);
        primaryStage.show();

        Socket socket = new Socket("www.google.com", 587 );
    }
}

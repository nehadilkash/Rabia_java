package assignment;

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
        primaryStage.setTitle("Exercise33_02Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread thread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);

                Platform.runLater(() -> {
                    ta.appendText("Exercise33_02Server started at " + new Date() + "\n");
                });


                while (true) {
                    Socket socket = serverSocket.accept();
                    ta.appendText("Connected to a client at " + new Date() + "\n");
                    DataInputStream dataInputStreamFromClient = new DataInputStream(socket.getInputStream());
                    DataOutputStream dataOutputStreamToClient = new DataOutputStream(socket.getOutputStream());
                    double weight = dataInputStreamFromClient.readDouble();
                    double height = dataInputStreamFromClient.readDouble();
                    Platform.runLater(() -> {
                        ta.appendText("Weight : " + weight + "\n");
                        ta.appendText("Height : " + height + "\n");
                    });
                    String result = calculateBmi(weight, height);

                    Platform.runLater(() -> {
                        ta.appendText(result + "\n");
                    });
                    dataOutputStreamToClient.writeUTF(result);
                }


            } catch (Exception e) {
                System.err.println("Exception occurred");
            }


        });

        thread.start();

    }

    private String calculateBmi(double weight, double height) {
        String result;
        final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
        final double METERS_PER_INCH = 0.0254; // Constant

        // Compute BMI
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        double bmi = weightInKilograms /
                (heightInMeters * heightInMeters);

        // Display result

        result = "BMI is " + String.format("%.2f", bmi) + ".";
        if (bmi < 18.5)
            result = result + "Underweight";
        else if (bmi < 25)
            result = result + "Normal";
        else if (bmi < 30)
            result = result + "Overweight";
        else
            result = result + "Obese";

        return result;
    }
}
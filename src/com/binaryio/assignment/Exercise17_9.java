package com.binaryio.assignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Exercise17_9 extends Application {
    static TextField nameTf;
    static TextField streetTf;
    static TextField cityTf;
    static TextField stateTf;
    static TextField zipTf;

    static final int NAME_SIZE = 32;
    static final int STREET_SIZE = 32;
    static final int CITY_SIZE = 20;
    static final int STATE_SIZE = 2;
    static final int ZIP_SIZE = 5;
    static final int TOTAL = 91;
    static List<String> addresses = new ArrayList<>();
    static int pointer;
    static File f;

    @Override
    public void start(Stage primaryStage) throws Exception {
        f = new File("addresses.dat");
        f.createNewFile();
        String s = FileOperation.retrieve(f);
        FileOperation.initAddressList(s);

        BorderPane mainPane = new BorderPane();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 5, 5, 5));


        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Street"), 0, 1);
        gridPane.add(new Label("City"), 0, 2);

        nameTf = new TextField();
        streetTf = new TextField();
        cityTf = new TextField();
        cityTf.setMaxWidth(70);
        stateTf = new TextField();
        stateTf.setMaxWidth(40);
        zipTf = new TextField();
        zipTf.setMaxWidth(60);

        HBox addressHBox = new HBox(5, cityTf, new Label("State"), stateTf, new Label("Zip"), zipTf);

        Button addButton = new Button("Add");
        Button firstButton = new Button("First");
        Button nextButton = new Button("Next");
        Button previousButton = new Button("Previous");
        Button lastButton = new Button("Last");
        Button updateButton = new Button("Update");

        addButton.setOnAction(e -> {

            FileOperation.add();

        });

        firstButton.setOnAction(e -> {
            FileOperation.first();
        });

        previousButton.setOnAction(e -> {
            FileOperation.previous();
        });

        lastButton.setOnAction(e -> {
            FileOperation.last();
        });

        updateButton.setOnAction(event -> {
            FileOperation.update(pointer);
        });

        nextButton.setOnAction(e -> {
            FileOperation.next();
        });


        HBox buttonHbox = new HBox(5, addButton, firstButton, nextButton, previousButton, lastButton, updateButton);

        gridPane.add(nameTf, 1, 0);
        gridPane.add(streetTf, 1, 1);
        gridPane.add(addressHBox, 1, 2);

        mainPane.setTop(gridPane);
        mainPane.setBottom(buttonHbox);

        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 17.9 ");
        primaryStage.show();

    }

    static class FileOperation {

        public static int offset = 0;

        private static void initAddressList(String s) {
            int len = s.length();
            while (len > 0) {
                len = len - TOTAL;
                addresses.add(s.substring(len));
                s = s.substring(0, len);
            }
        }

        protected static String retrieve(File file) {
            String read = "";
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {

                }
            } else {
                try {
                    RandomAccessFile raf = new RandomAccessFile(file, "r");
                    while (true) {
                        read = read.concat(raf.readUTF());
                    }

                } catch (EOFException eof) {
                    System.out.println("End of File reached!");
                    return read;
                } catch (IOException ioException) {

                }
            }
            return read;
        }

        protected static void store() throws IOException {
            boolean b = false;
            if (!f.exists()) {
                try {
                    b = f.createNewFile();
                } catch (Exception e) {
                    try {
                        f.setWritable(true);
                        b = f.createNewFile();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            try {
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                for (String address : addresses) {
                    raf.writeUTF(address);
                }

                raf.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void first() {
            if (addresses.size() > 0) {
                pointer = 0;
                setCurrentAddress(addresses.get(pointer));
            }
        }

        private static void next() {
            if (pointer < addresses.size() - 1) {
                ++pointer;
                setCurrentAddress(addresses.get(pointer));
            }

        }

        private static void add() {
            System.out.println(getAddressString());
            addresses.add(getAddressString());
        }

        private static void previous() {
            if (pointer > 0) {
                --pointer;
                setCurrentAddress(addresses.get(pointer));
            }
        }

        private static void update(int pointer) {
            addresses.set(pointer, getAddressString());

        }


        private static void last() {
            setCurrentAddress(addresses.get(addresses.size() - 1));
        }


        public static String getAddressString() {
            String address = "";
            String name = nameTf.getText();

            for (int i = name.length(); i < NAME_SIZE; i++) {
                name += " ";
            }
            address += name;

            String street = streetTf.getText();
            for (int i = street.length(); i < STREET_SIZE; i++) {
                street += " ";
            }
            address += street;

            String city = cityTf.getText();
            for (int i = city.length(); i < CITY_SIZE; i++) {
                city += " ";
            }
            address += city;

            String state = stateTf.getText();
            for (int i = state.length(); i < STATE_SIZE; i++) {
                state += " ";
            }
            address += state;

            String zip = zipTf.getText();

            for (int i = zip.length(); i < ZIP_SIZE; i++) {
                zip += " ";
            }
            address += zip;
            System.out.println("size of address" + address.getBytes(StandardCharsets.UTF_8).length);
            return address;

        }

        private static void setCurrentAddress(String fixLenStr) {
            nameTf.setText(fixLenStr.substring(0, 32));
            streetTf.setText(fixLenStr.substring(32, 64));
            cityTf.setText(fixLenStr.substring(64, 84));
            stateTf.setText(fixLenStr.substring(84, 86));
            zipTf.setText(fixLenStr.substring(86));

        }
    }
}




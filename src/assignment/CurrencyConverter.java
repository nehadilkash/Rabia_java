package assignment;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox topHbox = new HBox();
        TextField amountTf = new TextField();
        amountTf.setMinWidth(280);
        amountTf.setAlignment(Pos.BASELINE_RIGHT);

        Button convertButton = new Button("Convert");
        topHbox.getChildren().addAll(new Label("US Dollars"), amountTf, convertButton);


        TextField canDollarsExchangeRateTf = new TextField();
        TextField euroExchangeRateTf = new TextField();
        TextField poundsExchangeRateTf = new TextField();

        TextField canDollersConvertedAmtTf = new TextField();
        TextField euroConvertedAmtTf = new TextField();
        TextField poundsConvertedAmtTf = new TextField();


        canDollarsExchangeRateTf.setAlignment(Pos.BASELINE_RIGHT);
        euroExchangeRateTf.setAlignment(Pos.BASELINE_RIGHT);
        poundsExchangeRateTf.setAlignment(Pos.BASELINE_RIGHT);
        canDollersConvertedAmtTf.setAlignment(Pos.BASELINE_RIGHT);
        euroConvertedAmtTf.setAlignment(Pos.BASELINE_RIGHT);
        poundsConvertedAmtTf.setAlignment(Pos.BASELINE_RIGHT);

        // Pane to hold the input/output
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Exchange Rate"), 1, 0);
        gridPane.add(new Label("Converted Amount"), 2, 0);

        gridPane.add(new Label("Canadian Dollars"), 0, 1);
        gridPane.add(canDollarsExchangeRateTf, 1, 1);
        gridPane.add(canDollersConvertedAmtTf, 2, 1);

        gridPane.add(new Label("Euro"), 0, 2);
        gridPane.add(euroExchangeRateTf, 1, 2);
        gridPane.add(euroConvertedAmtTf, 2, 2);

        gridPane.add(new Label("British Pounds"), 0, 3);
        gridPane.add(poundsExchangeRateTf, 1, 3);
        gridPane.add(poundsConvertedAmtTf, 2, 3);

        VBox mainVBox = new VBox(5);
        mainVBox.getChildren().addAll(new Label("Enter Dollar Amount"), topHbox, new Label("Display Exchange"), gridPane);


        convertButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountTf.getText());

            double canExchangeRate = Double.parseDouble(canDollarsExchangeRateTf.getText());
            double euroExchangeRate = Double.parseDouble(euroExchangeRateTf.getText());
            double poundExchangeRate = Double.parseDouble(poundsExchangeRateTf.getText());

            NumberFormat canadaCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);
            NumberFormat europeCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            NumberFormat britishCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);


            double canDollarConvertedAmount = canExchangeRate * amount;
            double euroConvertedAmount = euroExchangeRate * amount;
            double poundConvertedAmount = poundExchangeRate * amount;


            canDollersConvertedAmtTf.setText(canadaCurrencyFormat.format(canDollarConvertedAmount));
            euroConvertedAmtTf.setText(europeCurrencyFormat.format(euroConvertedAmount));
            poundsConvertedAmtTf.setText(britishCurrencyFormat.format(poundConvertedAmount));

        });

        Scene scene = new Scene(mainVBox, 400, 180);
        primaryStage.setTitle("Exercise36_06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }
}
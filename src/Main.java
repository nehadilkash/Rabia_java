import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;

public class Main extends Application {

    // Statement for executing queries
    private Statement stmt;
    private ResultSet resultSet;
    private TableView tableView;

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu orderMenu = new Menu("Orders");
        Menu customerMenu = new Menu("Customers");
        Menu employeeMenu = new Menu("Employees");
        menuBar.getMenus().addAll(orderMenu, customerMenu, employeeMenu);

        // create order menu items
        MenuItem orderTotalItem = new MenuItem("Print Order Total");
        MenuItem orderDetailsItem = new MenuItem("Print Order Details");
        orderMenu.getItems().addAll(orderTotalItem, orderDetailsItem);

        // create customer menu items
        MenuItem customerByStateItem = new MenuItem("Print Customers by State");
        customerMenu.getItems().add(customerByStateItem);

        // create employee menu items
        MenuItem employeeByBirthdayItem = new MenuItem("Print Employees by Birthday");
        employeeMenu.getItems().add(employeeByBirthdayItem);

        // create main pane
//        BorderPane mainPane = new BorderPane();


        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);

        tableView = new TableView();
        orderTotalItem.setOnAction(event -> {
            try {
                // create input dialog to get order number
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Order Details");
                dialog.setHeaderText("Please enter an order number:");
                dialog.setContentText("Order number:");
                dialog.showAndWait().ifPresent(orderNumber -> {
                    String query = "SELECT ProductID, Quantity, UnitPrice, Discount FROM `Order Details` WHERE OrderID = " + orderNumber + " ORDER BY Quantity ASC";
                    buttonAction(query);
                });
            } catch (Exception e) {

            }
        });

        orderDetailsItem.setOnAction(event -> {
            try {
                // create input dialog to get order number
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Order Total");
                dialog.setHeaderText("Please enter an order number:");
                dialog.setContentText("Order number:");
                dialog.showAndWait().ifPresent(orderNumber -> {
                    String query = "SELECT OrderDate, Freight, ProductID, Quantity, UnitPrice, Discount FROM Orders inner join `Order Details` on OrderID = " + orderNumber;
                    buttonAction(query);
                });
            } catch (Exception e) {

            }
        });

        customerByStateItem.setOnAction(event -> {
            try {
                // create input dialog to get order number
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Customer");
                dialog.setHeaderText("Please enter region:");
                dialog.setContentText("Customer Name:");
                dialog.showAndWait().ifPresent(customer -> {
                    String query = "SELECT Customers.CompanyName AS [Company Name], "
                            + "Customers.City AS [City] "
                            + "FROM Customers "
                            + "WHERE Region = '" + customer + "' "
                            + "ORDER BY City"
                            ;
                    buttonAction(query);
                });
            } catch (Exception e) {

            }
        });

        employeeByBirthdayItem.setOnAction(event -> {
            try {
                // create input dialog to get order number
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Employee Birthday");
                dialog.setHeaderText("Please enter Year:");
                dialog.setContentText("Year:");
                dialog.showAndWait().ifPresent(year -> {
                    String query = "SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM Employees WHERE YEAR(birth_date) =  " + year;
                    buttonAction(query);
                });
            } catch (Exception e) {

            }
        });

        pane.setBottom(tableView);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NorthWind Database Query Tool");
        primaryStage.show();
        initializeDB();

    }

    private void buttonAction(String query) {
        tableView.getItems().clear();
        try {
            resultSet = stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showContents(resultSet);
    }

    private void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            System.out.println("Database connected");

            // Create a statement
            stmt = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showContents(ResultSet resultset) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        tableView.getColumns().clear();
        try {
            for (int i = 0; i < resultset.getMetaData().getColumnCount(); i++) {
                // We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(resultset.getMetaData().getColumnName(i + 1));

                // col.setCellValueFactory(TextFieldTableCell.forTableColumn());
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        if (param == null || param.getValue() == null || param.getValue().get(j) == null) {
                            return null;
                        }
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            while (resultset.next()) {
                // Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++) {
                    // Iterate Column
                    row.add(resultset.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            // Add to TableView
            tableView.setItems(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


}

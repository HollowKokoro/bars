package com.example.barsclient;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) {

        TableView tableView = new TableView();

        TableColumn<Contract, String> column1 = new TableColumn<>("Contract");
        column1.setCellValueFactory(new PropertyValueFactory<>("contract"));


        TableColumn<Contract, String> column2 = new TableColumn<>("Created");
        column2.setCellValueFactory(new PropertyValueFactory<>("created"));

        TableColumn<Contract, String> column3 = new TableColumn<>("Updated");
        column2.setCellValueFactory(new PropertyValueFactory<>("updated"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

        tableView.getItems().add(new Contract());
        tableView.getItems().add(new Contract());

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
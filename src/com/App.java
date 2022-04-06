package com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static com.Main.daneZBazy;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout, 400,200);
        Label label = new Label();
        TableView tableView = new TableView<>();

        layout.setCenter(tableView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DataBase");
        primaryStage.show();
    }


}

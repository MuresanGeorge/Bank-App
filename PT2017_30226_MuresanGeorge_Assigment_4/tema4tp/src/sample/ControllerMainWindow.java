package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ControllerMainWindow  {

    public void initPersonView() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Person View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("PersonView.fxml"));
        GridPane root = loader.load();

        ControllerPersonView controllerPersonView = loader.getController();
        controllerPersonView.setServices();


        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
    public void initContView() throws IOException, ClassNotFoundException {
        Stage stage = new Stage();
        stage.setTitle("Cont View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ContView.fxml"));
        GridPane root = loader.load();

        ControllerContView controllerContView = loader.getController();
        controllerContView.setServices();

        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }




}

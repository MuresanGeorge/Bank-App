package sample;


import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPersonView {

    private Banca banca;
    private ObservableList<Persoana> model;
    Ser s=new Ser();




    @FXML
    private TableView<Persoana> tableview = new TableView<Persoana>();
    @FXML
    private TableColumn<Persoana, String> numeCol = new TableColumn<>();
    @FXML
    private TableColumn<Persoana, String> cnpCol = new TableColumn<>();
    @FXML
    private TableColumn<Persoana, String> sexCol = new TableColumn<>();
    @FXML
    TextField numeText = new TextField();
    @FXML
    TextField cnpText = new TextField();
    @FXML
    TextField sexText = new TextField();
    @FXML
    TextField numeupdateText = new TextField();
    @FXML
    TextField cnpupdateText = new TextField();
    @FXML
    TextField sexupdateText = new TextField();


    public void setServices() {

        this.banca = new Banca();
        this.model = FXCollections.observableArrayList(banca.getPersoane());
        tableview.setItems(model);
    }

    @FXML
    public void initialize() {
        numeCol.setCellValueFactory(new PropertyValueFactory<Persoana, String>("Nume"));
        cnpCol.setCellValueFactory(new PropertyValueFactory<Persoana, String>("Cnp"));
        sexCol.setCellValueFactory(new PropertyValueFactory<Persoana, String>("Sex"));
    }
    public Banca getbanca()
    {
        return this.banca;
    }

    public void handleAdd() throws IOException, ClassNotFoundException {

        //banca=s.importb();

        Persoana p = new Persoana(numeText.getText(), cnpText.getText(), sexText.getText());
        banca.addPerson(p);
        s.exportb(banca);
        this.model = FXCollections.observableArrayList(banca.getPersoane());
        tableview.setItems(model);


    }

    public void handleDelete() throws IOException, ClassNotFoundException {
        Persoana p = tableview.getSelectionModel().getSelectedItem();
        banca.delPerson(p);
        s.exportb(banca);
        this.model = FXCollections.observableArrayList(banca.getPersoane());
        tableview.setItems(model);
        //banca=s.importb();


    }

    public void handleUpdate() throws IOException, ClassNotFoundException {
        Persoana p = tableview.getSelectionModel().getSelectedItem();
        //Persoana p=new Persoana(numeText.getText(), cnpText.getText(), sexText.getText());
        banca.editPerson(p, numeupdateText.getText(), cnpupdateText.getText(), sexupdateText.getText());
       // handleAdd();
        banca.addPerson(p);
        s.exportb(banca);
        this.model = FXCollections.observableArrayList(banca.getPersoane());
        tableview.setItems(model);
        //banca=s.importb();

    }
    public void refresh() throws IOException, ClassNotFoundException {
        banca=s.importb();
        s.exportb(banca);

        this.model = FXCollections.observableArrayList(banca.getPersoane());
        tableview.setItems(model);

    }
}







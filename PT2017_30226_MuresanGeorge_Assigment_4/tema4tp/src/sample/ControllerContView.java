package sample;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ControllerContView {

    private Banca banca;
    private ObservableList<Cont> model;
    Ser s=new Ser();



    @FXML
    private TableView<Cont> tablecont=new TableView<>();
    @FXML
    private TableColumn<Cont,Integer> idCol=new TableColumn<>();
    @FXML
    private TableColumn<Cont,Integer> soldCol=new TableColumn<>();
    @FXML
    private TableColumn<Cont,String> persCol=new TableColumn<Cont,String>("nume persoana");
    @FXML
    TextField tipText=new TextField();
    @FXML
    TextField sumaText=new TextField();
    @FXML
    TextField idText=new TextField();
    @FXML
    TextField persText=new TextField();


    public void setServices() throws IOException, ClassNotFoundException {

       this.banca=new Banca();
        this.model=FXCollections.observableList(banca.getConturi());

        tablecont.setItems(model);

    }


    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<Cont, Integer>("id"));
        soldCol.setCellValueFactory(new PropertyValueFactory<Cont, Integer>("sold"));
        //persCol.setCellValueFactory(new PropertyValueFactory<Cont, String>("persoana"));



        persCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cont, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cont, String> p) {
                return p.getValue().getNumeP();
            }
        });

    }

    public void handleAddC() throws IOException {

        if(tipText.getText().equalsIgnoreCase("cheltuieli")) {

            String cnps = persText.getText();
            List<Persoana> listpers = banca.getPersoane();
            System.out.println("lista persoane");
            System.out.println(listpers);
            for (int i = 0; i < listpers.size(); i++) {
                if (listpers.get(i).getCnp().equalsIgnoreCase(cnps)) {
                    //Persoana p = new Persoana(listpers.get(i).getNume(),listpers.get(i).getCnp(),listpers.get(i).getSex() );
                    //p.setCnp(listpers.get(i).getCnp());
                   // p.setNume(listpers.get(i).getNume());
                  //  p.setSex(listpers.get(i).getSex());
                    Cont c = new Cheltuieli(listpers.get(i));
                    c.setId(Integer.parseInt(idText.getText()));
                    banca.addContChe(c, listpers.get(i));
                    s.exportb(banca);

                }
            }
        }
        else  if(tipText.getText().equalsIgnoreCase("economii")) {
            String cnps = persText.getText();
            List<Persoana> listpers = banca.getPersoane();

            System.out.println(listpers);
            for (int i = 0; i < listpers.size(); i++) {
                if (listpers.get(i).getCnp().equalsIgnoreCase(cnps)) {

                    Economii e = new Economii(listpers.get(i));
                    e.setId(Integer.parseInt(idText.getText()));
                    banca.addContEco(e, listpers.get(i));
                    s.exportb(banca);

                }
            }

        }
        this.model = FXCollections.observableArrayList(banca.getConturi());

        tablecont.setItems(model);
        System.out.println("lista conturi");
        System.out.println(banca.getConturi());

    }

    public void refresh() throws IOException, ClassNotFoundException {

        banca=s.importb();

        s.exportb(banca);
        this.model = FXCollections.observableArrayList(banca.getConturi());
        tablecont.setItems(model);

    }

    public void handleAdauga() throws IOException {
        Cont c = tablecont.getSelectionModel().getSelectedItem();
        if(c instanceof Economii) {
            ((Economii) c).adaugareBani(Integer.parseInt(sumaText.getText()));
            s.exportb(banca);
        }
        else

        {
            ((Cheltuieli)c).adaugareBani(Integer.parseInt(sumaText.getText()));
            s.exportb(banca);
        }

    }
    public void handleRetrage() throws IOException {
        Cont c = tablecont.getSelectionModel().getSelectedItem();
        if(c instanceof Economii) {
            ((Economii) c).retragereBani(Integer.parseInt(sumaText.getText()));
            s.exportb(banca);
        }
        else

        {
            ((Cheltuieli)c).retragereBani(Integer.parseInt(sumaText.getText()));
            s.exportb(banca);
        }

    }
   public void handleSterge() throws IOException {
        Cont c = tablecont.getSelectionModel().getSelectedItem();
        Persoana p=c.getTit();
        banca.delCont(p,c);
        s.exportb(banca);

    }


}

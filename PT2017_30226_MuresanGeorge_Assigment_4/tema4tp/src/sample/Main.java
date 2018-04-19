package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Hello World");

        ControllerMainWindow controllerMainWindow = new ControllerMainWindow();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
//        Ser s=new Ser();
//        HashMap<Persoana, List<Cont>> Conturi = new HashMap<Persoana, List<Cont>>();
//        Persoana p=new Persoana("TEST","2372732","m");
//        Persoana p2=new Persoana("Test2","321321122","s");
//        Economii e=new Economii(p);
//        Cheltuieli che=new Cheltuieli(p);
//        //Cheltuieli che=new Cheltuieli(p2);
//
//
//        Banca c=new Banca(Conturi);
//        try {
//            c=s.importb();
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
////        c.addPerson(p);
////        c.addPerson(p2);
////        c.addContEco(e,p);
////        c.addContChe(che,p);
//        //c.editPerson(p2,"M",2);
//        List<Cont>lis =c.getConturi();
//        List<Persoana>lis1=c.getPersoane();
//        c.editCont(p,2,che);
//
//        for(int i=0;i<lis.size();i++)
//        {
//            System.out.println(lis.get(i).toString());
//        }
//
//        s.exportb(c);



        //System.out.println(Conturi);
        //System.out.println();
        //c.delPerson(p);
        //System.out.println(Conturi);


    }
}

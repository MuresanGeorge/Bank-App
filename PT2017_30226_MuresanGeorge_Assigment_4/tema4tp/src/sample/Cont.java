package sample;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Created by George on 5/24/2017.
 */
public abstract  class Cont implements Serializable {
    public int sold;
    public Persoana p1;
    public int id;

    public abstract int getId() ;


    public abstract void setId(int id) ;


    public abstract int getSold() ;


    public abstract void setSold(int sold) ;


    public abstract String getP1() ;

    public abstract Persoana getTit();


    public abstract void setP1(Persoana p1) ;

    public SimpleStringProperty getNumeP(){
        return p1.getNumeP();
    }
   // public abstract  void adaugareBani(int s);


}

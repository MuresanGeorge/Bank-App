package sample;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Created by George on 5/24/2017.
 */
public class Persoana implements Serializable {
    public String nume;
    public String cnp;
    public String sex;

    public Persoana(String nume, String cnp, String sex) {
        this.nume = nume;
        this.cnp = cnp;
        this.sex = sex;
    }
    public Persoana() {

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public SimpleStringProperty getNumeP(){
        SimpleStringProperty numeP=new SimpleStringProperty(nume);
        return numeP;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Persoana other = (Persoana) obj;
        if (cnp == null) {
            if (other.cnp != null)
                return false;
        } else if (!cnp.equals(other.cnp))
            return false;
        return true;
    }

    public String toString(){
        return "numele :"+ nume + " " + " CNP: " + cnp +" sexul: "+ sex+  ".\n";
    }
}

package sample;

import java.io.Serializable;

/**
 * Created by George on 5/24/2017.
 */
public class Economii extends Cont implements Serializable {

    private int dobanda=10;


    public void adaugareBani (int s)
    {
        try
        {
            if(s>1000)
            {
                sold+=s;
                int intermediar=(sold*dobanda)/100;
                sold+=intermediar;
                System.out.println("au fost adaugati bani in economii "+sold);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Suma de adaugat este prea mica");
        }


    }
    public void retragereBani(int s)
    {
        try
        {
            if(s<=sold)
            {
                sold-=s;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("nu s-au putut retreage bani din contul de economii");
        }

    }


    public Economii(Persoana p1) {
        this.p1=p1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;

    }

    @Override
    public int getSold() {
        return sold;
    }

    @Override
    public void setSold(int sold) {
        this.sold=sold;
    }

    @Override
    public String getP1() {
        return p1.getNume();
    }

    public Persoana getTit(){return p1;}

    @Override
    public void setP1(Persoana p1) {
        this.p1=p1;

    }

    public String toString(){
        return "Cont Economii, sold: " + sold + "---idul"+id+ "\n";
    }
}

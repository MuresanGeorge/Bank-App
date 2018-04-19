package sample;

import java.io.Serializable;

/**
 * Created by George on 5/24/2017.
 */
public class Cheltuieli extends Cont implements Serializable{

    public Cheltuieli(Persoana p1) {
        this.p1=p1;
    }
   // public Cheltuieli()
    //{

   // }

    public void adaugareBani (int s)
    {
        try
        {
            if(s>0)
            {
                sold+=s;

                System.out.println("au fost adaugati bani in cheltuieli"+sold);
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
            System.out.println("nu s-au putut retreage bani din contul de chlewtuilei");
        }

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
        return "Cont Cheltuieli, sold: " + sold + "--idul "+ id + "\n";
    }
}

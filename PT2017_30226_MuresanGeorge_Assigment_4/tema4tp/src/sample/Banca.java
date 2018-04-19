package sample;

import java.io.*;
import java.util.*;

/**
 * Created by George on 5/24/2017.
 */
public class Banca implements Serializable,BankProc{

    private HashMap<Persoana,List<Cont>> HBanca;
    //private ArrayList<Observer> obi=new ArrayList<Observer>();

    public Banca(HashMap<Persoana, List<Cont>> HBanca) {
        this.HBanca = HBanca;
    }
    public Banca() {
        HBanca=new HashMap<>();
    }

    public HashMap<Persoana, List<Cont> >getHBanca() {
        return HBanca;
    }

    public void setHBanca(HashMap<Persoana, List<Cont>> HBanca) {
        this.HBanca = HBanca;
    }

    public void addPerson(Persoana p) {
        if(equals(p)==false)
        {
            List<Cont> lc=new ArrayList<Cont>();
            //obi.add(lc);
            HBanca.put(p,lc);
        }
      //  System.out.println(getPersoane());
    }

    public void delPerson(Persoana p)
    {
        if(HBanca.containsKey(p))
        {
            HBanca.remove(p);
        }
    }

    public void editPerson(Persoana p,String numen,String cnpn,String sexn)
    {
        List<Cont> lc=new ArrayList<>();

       if(HBanca.containsKey(p))
       {
           HBanca.remove(p);
       }
        p.setCnp(cnpn);
        p.setNume(numen);
        p.setSex(sexn);
        HBanca.put(p,lc);

    }

    public List<Persoana> getPersoane()
    {
        List<Persoana> listpers=new ArrayList<Persoana>();
        Set<Persoana>keys=HBanca.keySet();
        for(Persoana key:keys)
        {
            listpers.add(key);
            //System.out.println(key);
        }
        return listpers;
    }
    //------------------------------------------------------gata cu persoanele----------------------------------------------------------



    public void addContEco(Economii ec,Persoana p)
    {
        if(HBanca.containsKey(p))
        {
            List<Cont> listacon=HBanca.get(p);
            listacon.add(ec);
            HBanca.put(p,listacon);
        }
    }
    public void addContChe(Cont che,Persoana p)
    {   System.out.println("personae inainte de if");
        System.out.println(HBanca);
        if(HBanca.containsKey(p))
        {
            List<Cont> listacon=HBanca.get(p);
            listacon.add(che);
            HBanca.put(p,listacon);
            System.out.println("lista conturi din add banca");
            System.out.println(listacon);
        }
        else
            System.out.println("nu contine persoana "+p);
    }
    public void delCont(Persoana p,Cont c)
    {
        if(HBanca.containsKey(p))
        {
            List<Cont> listacon= HBanca.get(p);
            listacon.remove(c);
            HBanca.put(p,listacon);
        }
    }

    public void editCont(Persoana p,int schimb,Cont c)
    {
        if(HBanca.containsKey(p))
        {
            List<Cont> listcon=HBanca.get(p);
            for(int i=0;i<listcon.size();i++)
            {
                if( listcon.get(i)==c)
               {
                   listcon.get(i).setId(schimb);
               }
            }
        }
    }

    public List<Cont> getConturi()
    {
        List<Cont> listaconturi=new ArrayList<Cont>();
        List<Cont> listcon=new ArrayList<Cont>();
        for (Map.Entry<Persoana,List<Cont>> me:HBanca.entrySet())
        {

            listcon=me.getValue();
            for(int i=0;i<listcon.size();i++)
            {
                listaconturi.add(listcon.get(i));
            }
        }
        return listaconturi;
    }
    //-------------------------------------------------------gata cu cu conturile--------------------------------------------------------






}

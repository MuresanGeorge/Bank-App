package sample;

import java.io.*;

/**
 * Created by George on 5/25/2017.
 */
public class Ser
{
        public static Banca importb() throws IOException, ClassNotFoundException {//deseriliazre

            Banca b;

            FileInputStream fisierConturi = new FileInputStream("Banca.ser");
            ObjectInputStream o = new ObjectInputStream(fisierConturi);
            b = (Banca) o.readObject();
            o.close();
            fisierConturi.close();

            return b;
        }


        public static void exportb(Banca b) throws IOException {

            FileOutputStream f = new FileOutputStream("Banca.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(b);

            o.close();
            f.close();

        }
}

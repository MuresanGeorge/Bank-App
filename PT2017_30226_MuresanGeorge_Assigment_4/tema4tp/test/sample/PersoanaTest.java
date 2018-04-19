package sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bianca on 5/26/2017.
 */
public class PersoanaTest {
    @Test
    public void getNume() throws Exception {
            Persoana p=new Persoana();
        p.setNume("PERSOANATEST");
        assertEquals("PERSOANATEST",p.getNume());
    }

}
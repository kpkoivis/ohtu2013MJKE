/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.spring.domain.Viite;

/**
 *
 * @author elmhaapa
 */
public class ViiteTest {

    static Viite viite;

    public ViiteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        viite = new Viite();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testId() {
        viite.setId(123456789L);
        long id = viite.getId();
        assertEquals(id, 123456789L);
    }

    @Test
    public void testToStringBiBTex() {
        viite.setViiteType("inproceedings");
        String oikea = "@inproceedings{";
        viite.setReferenceId("123456");
        oikea += "123456" + ",\n";
        viite.addItem("author", "Äyskäri Ö. Ämpäri");
        oikea += "author = {\\\"{A}ysk\\\"{a}ri \\\"{O}. \\\"{A}mp\\\"{a}ri},\n";
        viite.addItem("title", "Minun otsikkoni");
        oikea += "title = {Minun otsikkoni},\n";
        viite.addItem("booktitle", "How to get rich in ten days");
        oikea += "booktitle = {How to get rich in ten days},\n";
        viite.addItem("year", "1900");
        oikea += "year = {1900},\n";
        oikea += "}\n";
        assertEquals(oikea, viite.toStringBiBTex());
    }
}
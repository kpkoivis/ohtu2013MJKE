/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.spring.domain.Viite;
import wad.spring.domain.ViiteItem;

/**
 *
 * @author elmhaapa
 */
public class ViiteTest {

    static Viite viite;
    static ViiteItem testViiteItem;

    public ViiteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        viite = new Viite();
        testViiteItem = new ViiteItem();
        testViiteItem.setFieldName("Kentän nimi");
        testViiteItem.setFieldValue("Kentän arvo");
        viite.setId(12345L);
        viite.setReferenceId("123");
        viite.setViiteType("Tyyppi");
        ArrayList<ViiteItem> l = new ArrayList();
        l.add(testViiteItem);
        viite.setItems(l);
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
        long id = viite.getId();
        assertEquals(id, 12345L);
    }
    @Test
    public void testReferenceId() {
        String id = viite.getReferenceId();
        assertEquals(id, "123");
    }
    @Test
    public void testViiteType() {
        String type = viite.getViiteType();
        assertEquals(type, "Tyyppi");
    }
    @Test
    public void testGetItems() {
        for (ViiteItem i : viite.getItems()) {
            assertEquals(i.getFieldName(), "Kentän nimi");
        }
    }
    @Test
    public void testAddRemoveItem() {
        ViiteItem testi = new ViiteItem();
        testi.setFieldName("a");
        testi.setFieldValue("a");
        assertEquals(viite.addItem(testi), true);
        assertEquals(viite.removeItem(testi), true);
    }
    @Test
    public void testAddItem() {
        assertEquals(viite.addItem("a", "b"), true);
        assertEquals(viite.removeItem("a"), true);
    }
    
    @Test
    public void testGetItemValueWithName() {
        assertEquals(viite.getItemValueWithFieldName("Kentän nimi"),"Kentän arvo");
    }

    @Test
    public void testToStringBiBTex() {
        Viite a = new Viite();
        a.setViiteType("inproceedings");
        String oikea = "@inproceedings{";
        a.setReferenceId("123456");
        oikea += "123456" + ",\n";
        a.addItem("author", "Äyskäri Ö. Ämpäri");
        oikea += "author = {\\\"{A}ysk\\\"{a}ri \\\"{O}. \\\"{A}mp\\\"{a}ri},\n";
        a.addItem("title", "Minun otsikkoni");
        oikea += "title = {Minun otsikkoni},\n";
        a.addItem("booktitle", "How to get rich in ten days");
        oikea += "booktitle = {How to get rich in ten days},\n";
        a.addItem("year", "1900");
        oikea += "year = {1900},\n";
        oikea += "}\n";
        assertEquals(oikea, a.toStringBiBTex());
    }
    
    @Test
    public void testRemoveNonexistentItemByNameReturnsFalse() {
        assertEquals(viite.removeItem("b"), false);
    }
    
    @Test
    public void testGetItemValueWithFieldNameWhenDoesNotExist() {
        assertEquals(viite.getItemValueWithFieldName("bbb"), null);
    }

    @Test
    public void testGetItemValueWithFieldNameWhenDoesExist() {
        assertEquals(viite.getItemValueWithFieldName("Kentän nimi"), "Kentän arvo");
    }

}
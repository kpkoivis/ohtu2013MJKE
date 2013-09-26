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
    public void testAuthor() {
        viite.setAuthor("Scrooge McDuck");
        assertEquals(viite.getAuthor(), "Scrooge McDuck");
    }
    @Test
    public void testTitle() {
        viite.setTitle("Minun otsikkoni");
        assertEquals(viite.getTitle(), "Minun otsikkoni");
    }
    @Test
    public void testBookTitle() {
        viite.setBookTitle("How to get rich in ten days");
        assertEquals(viite.getBookTitle(), "How to get rich in ten days");
    }
    @Test
    public void testItemYear() {
        viite.setItemYear("1900");
        assertEquals(viite.getItemYear(), "1900");
    }
}
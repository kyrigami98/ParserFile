
package parserfile;

import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserFileTest {
    
    public ParserFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        ParserFile.main(args);
    }

    @Test
    public void testParser() {
        System.out.println("Parser");
        String file = "";
        String log = "";
        ParserFile.Parser(file, log);
    }

    @Test
    public void testLecture() throws Exception {
        System.out.println("Lecture");
        BufferedReader buff = null;
        String[] expResult = null;
        String[] result = ParserFile.Lecture(buff);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testAfficherParsedFile() throws Exception {
        System.out.println("AfficherParsedFile");
        String log = "";
        ParserFile.AfficherParsedFile(log);
    }

    @Test
    public void testVerify() {
        System.out.println("Verify");
        String[] format = null;
        String expResult = "";
        String result = ParserFile.Verify(format);
        assertEquals(expResult, result);
      
    }

    @Test
    public void testAfficher() {
        System.out.println("Afficher");
        String result_2 = "";
        ParserFile.Afficher(result_2);
    }

    @Test
    public void testEnregister() throws Exception {
        System.out.println("enregister");
        String result_2 = "";
        String filename = "";
        ParserFile.enregister(result_2, filename);
    }

    @Test
    public void testCheksum() {
        System.out.println("cheksum");
        String result_2 = "";
        String expResult = "";
        String result = ParserFile.cheksum(result_2);
        assertEquals(expResult, result);
    }
    
}

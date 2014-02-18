package mongoConnection;

import com.mongodb.DB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eirikstadheim
 */
public class ContestManagerTest {
    
    public ContestManagerTest() {
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

    /**
     * Test of getActiveContests method, of class ContestManager.
     */
    @Test
    public void testGetActiveContests() {
        System.out.println("getActiveContests");
        DB db = null;
        String expResult = "";
        String result = ContestManager.getActiveContests(db);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInactiveContests method, of class ContestManager.
     */
    @Test
    public void testGetInactiveContests() {
        System.out.println("getInactiveContests");
        DB db = null;
        int skip = 0;
        String expResult = "";
        String result = ContestManager.getInactiveContests(db, skip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

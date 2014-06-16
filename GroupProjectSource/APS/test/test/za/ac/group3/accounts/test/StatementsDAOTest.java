package test.za.ac.group3.accounts.test;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.derby.iapi.sql.Statement;
import org.junit.Before;
import org.junit.Test;

public class StatementsDAOTest {
    protected String dbURL = "jdbc:derby:memory:apsdb;create=true;user=aps;password=apsadmin";
    protected String tableName = "aps_statements";

    // jdbc Connection
    protected Connection conn = null;
    protected Statement stmt = null;
    
    private void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
	@Before
	public void setUp() throws Exception {
		createConnection();
	}

	@Test
	public void test() {
		assertTrue(conn !=  null);
	}

}

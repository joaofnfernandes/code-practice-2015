import static org.junit.Assert.*;

import org.junit.Test;


/* 
 * Tests a query that returns all employee that receive more 
 * than their managers
 */
public class TestEmployeeVsManager {
    private static final String TEST_SETUP_PATH = System.getenv("PROJECT_PATH") + "test-resources/setup/employee-more-manager/";
    private static final String SQL_QUERY_FILE = System.getenv("PROJECT_PATH") + "src/sql/employee-more-manager.sql";
    
    private SqlTestEnvironment sqlHelper = new SqlTestEnvironment();

    private void bootstrapEmployeeTable(String filename) {
        final String bootstapFile = TEST_SETUP_PATH + filename;
        boolean createdSuccessfully = sqlHelper.setup(bootstapFile);
        assertTrue(String.format("Could not create Employee table from file %s", bootstapFile),
                    createdSuccessfully);
    }
    
    private String runQueryGetSalary() {
       return sqlHelper.executeQuery(SQL_QUERY_FILE);
    }
    
    // if no one has managers, result is empty
    @Test
    public void testNoManagers(){
        final String bootstrapFile = "no-managers.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }
    
    // if employees have manager, but don't receive more than them, return empty
    @Test
    public void testNoEmployeeReceivesMore() {
        final String bootstrapFile = "all-managers-receive-more.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "";
        String result = runQueryGetSalary();
        assertEquals(expected, result); 
    }

    // if a manager manager themself they can't make more than themselves
    @Test 
    public void testNoManagerManagesThemselves() {
        final String bootstrapFile = "managers-manage-themselves.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }

    // if two employees have the same manager
    // and one receives more than manager only that one is returned
    @Test
    public void testOneEmployeeReceivesMore() {
        final String bootstrapFile = "one-employee-receives-more.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "[{\"name\": \"Joe\"}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);

    }
}

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Tests a query that returns the second highest salary, or null 
 */
public class TestSecondHighest {
    private static final String TEST_SETUP_PATH = System.getenv("PROJECT_PATH") + "test-resources/setup/second-highest-salary/";
    private static final String SQL_QUERY_FILE = System.getenv("PROJECT_PATH") + "src/sql/second-highest-salary.sql";
    
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
    
    
    @Test
    public void testWithNoEmployees() {
        final String bootstrapFile = "no-employees.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "[{\"salary\": null}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }
    
    @Test
    public void testWithOneEmployee() {
        final String bootstrapFile = "one-employee.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "[{\"salary\": null}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }
    
    @Test
    public void testWithTwoEmployees() {
        final String bootstrapFile = "two-employees.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "[{\"salary\": 100}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }
    
    @Test
    public void testAllEmployeesSameSalary() {
        final String bootstrapFile = "same-salary.sql";
        bootstrapEmployeeTable(bootstrapFile);
        String expected = "[{\"salary\": null}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }
    
    @Test
    public void testThreeEmployeesAscendingSalary() {
        final String bootstrapFile = "three-employees-asc-salaries.sql";
        bootstrapEmployeeTable(bootstrapFile);
        // expect second salary
        String expected = "[{\"salary\": 200}]";
        String result = runQueryGetSalary();
        assertEquals(expected, result);
    }

}

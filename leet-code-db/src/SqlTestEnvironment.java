import java.io.*;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SqlTestEnvironment {
    private static int SETUP_TIMEOUT = 10;
    private static String COMMAND_DELIMITER = ";";

    public Connection connection = null;

    public SqlTestEnvironment() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // Populates a database by running the SQL on the file. Returns true
    // if setup was successful, false otherwise.
    public boolean setup(String filename) {
        if (connection == null) {
            return false;
        }

        boolean setupSuccessful = true;
        Scanner scanner = null;

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(SETUP_TIMEOUT);

            try {
                scanner = new Scanner(new File(filename));
            } catch (NullPointerException e) {
                throw new FileNotFoundException();
            }
            scanner.useDelimiter(COMMAND_DELIMITER);

            String sqlCommand;
            while (scanner.hasNext()) {
                sqlCommand = scanner.next();
                statement.executeUpdate(sqlCommand);
            }
            statement.close();

        } catch (SQLTimeoutException e) {
            setupSuccessful = false;
            System.err.println(String.format(
                    "Timout reading file '%s', when setting up test\n%s",
                    filename, e.getMessage()));
        } catch (SQLException e) {
            setupSuccessful = false;
            System.err.println(String.format(
                    "Error running SQL when setting up test\n%s",
                    e.getMessage()));
        } catch (FileNotFoundException e) {
            setupSuccessful = false;
            System.err.println(String.format(
                    "File '%s' not found, when setting up test\n%s", filename,
                    e.getMessage()));
        } finally {
            if (scanner != null) {
                scanner.close();
            }

        }
        return setupSuccessful;
    }

    /*
     * Reads a SQL query from a file, and returns its result as a json string
     */
    public String executeQuery(String filename) {
        ResultSet resultSet = null;
        Scanner scanner = null;

        try {
            try {
                scanner = new Scanner(new File(filename));
            } catch (NullPointerException e) {
                throw new FileNotFoundException();
            }
            scanner.useDelimiter(COMMAND_DELIMITER);
            String sqlCommand = scanner.next();
            scanner.close();

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
        } catch (FileNotFoundException e) {
            System.err.println(String.format(
                    "File '%s' not found, when executing query\n%s", filename,
                    e.getMessage()));
        } catch (NoSuchElementException e) {
            System.err.println(String.format(
                    "Could not find a valid SQL query in file '%s'\n%s",
                    filename, e.getMessage()));
        } catch (SQLException e) {
            System.err.println(String.format("Error executing SQL query\n%s",
                    e.getMessage()));
        }
        
        String result = ResultSetConverter.convert(resultSet);
        return result;
    }

    public void tearDown() {
        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

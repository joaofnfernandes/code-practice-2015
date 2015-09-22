package week2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSubset {

    @Test
    public void testSubsetK0() {
        String[] args = new String[] { "0" };
        String input = "A B C D E F G H I";

        String result = executeSubset(args, input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSubsetK2() {
        String[] args = new String[] { "2" };
        String input = "A B";

        String result = executeSubset(args, input);

        assertTrue("Result should be AB or BA, but was \"" + result + "\"", result.matches("^(A\nB)|(B\nA)$"));
    }

    @Test
    public void testSubsetKN() {
        String[] args = new String[] { "3" };
        String input = "A B C D E F G H I";

        String result = executeSubset(args, input);

        assertTrue("Result should be XYZ, but was \"" + result + "\"" , result.matches("^.\n.\n.$"));
    }

    private String executeSubset(String[] args, String input) {
        String result = "";
        // Save previous state
        PrintStream prevOutStream = System.out;
        InputStream prevInStream = System.in;

        // Create in/out streams for client to read/write
        ByteArrayInputStream clientInStream = createInStreamWithContent(input);
        ByteArrayOutputStream clientOutStream = new ByteArrayOutputStream();
        PrintStream clientPrintStream = new PrintStream(clientOutStream);
        
        // Execute client, and get what it wrote to standard input
        try {
            System.setOut(clientPrintStream);
            System.setIn(clientInStream);
            Subset.main(args);
            System.out.flush();
            result = new String(clientOutStream.toByteArray());

        } finally {
            clientPrintStream.close();
            try {
                clientInStream.close();
            } catch (IOException e) {
                // Do nothing
            }
            System.setOut(prevOutStream);
            System.setIn(prevInStream);
        }
        return result;
    }

    private ByteArrayInputStream createInStreamWithContent(String content) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outStream);
        printStream.print(content);
        printStream.flush();
        ByteArrayInputStream inStream = new ByteArrayInputStream(
                outStream.toByteArray());
        printStream.close();
        return inStream;
    }

}

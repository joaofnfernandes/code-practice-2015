package chapter8.matrixTransversal;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMatrixTransversal {
	
	@Test
	public void TestTransversalMatrix2() {
		MatrixTransversal transversal = new MatrixTransversal(2);
		String[] expectedResults = new String[] {"[0, 1, 3, 2]", "[0, 2, 3, 1]"};
		String result = transversal.Transverse();
		
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}
	
	@Test
	public void TestTransversalMatrix3() {
		MatrixTransversal transversal = new MatrixTransversal(3);
		String[] expectedResults = new String[] {"[0, 1, 2, 5, 4, 3, 6, 7, 8]",
												"[0, 3, 6, 7, 4, 1, 2, 5, 8]"};
		String result = transversal.Transverse();
		
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}
}

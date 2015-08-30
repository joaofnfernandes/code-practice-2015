package chapter8.queens;

import org.junit.*;
import static org.junit.Assert.*;

public class TestQueenSolver {
	
	@Test
	public void Test2Queens() {
		String[] expectedResults = new String[] {"[Q_][__]", "[_Q][__]",
											"[__][Q_]", "[__][_Q]"};
		
		QueenSolver solver = new QueenSolver(2);
		String result = solver.Solve();
		
		
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}
	
	@Test
	public void Test3Queens() {
		String[] expectedResults = new String[] {"[Q__][__Q][___]", "[Q__][___][_Q_]"};

		QueenSolver solver = new QueenSolver(3);
		String result = solver.Solve();
		
		for(String expected : expectedResults) {
		assertTrue(result.contains(expected));
		}
	}
	
	@Ignore @Test
	// Solution tree for 8-queens is too deep
	public void Test8Queens() {
		String[] expectedResults = new String[] {"[Q________]" +
												"[____Q___]" +
												"[_Q______]" +
												"[_____Q__]" +
												"[__Q_____]" +
												"[______Q_]" +
												"[___Q____]" +
												"[_______Q]"};

		QueenSolver solver = new QueenSolver(8);
		String result = solver.Solve();
		
		System.out.println(result);
		for(String expected : expectedResults) {
		assertTrue(result.contains(expected));
		}
	}

}

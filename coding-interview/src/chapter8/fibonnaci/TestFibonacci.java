package chapter8.fibonnaci;

import org.junit.Test;
import static org.junit.Assert.*;
import static chapter8.fibonnaci.Fibonacci.*;

public class TestFibonacci {
	
	@Test
	public void TestFib() {
		assertEquals(0, fib(-1));
		assertEquals(0, fib(0));
		assertEquals(1, fib(1));
		assertEquals(8, fib(6));
	}

}

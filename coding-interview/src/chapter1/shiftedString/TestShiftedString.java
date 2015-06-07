package chapter1.shiftedString;

import org.junit.Test;
import static org.junit.Assert.*;
import static chapter1.shiftedString.ShiftedString.*;

public class TestShiftedString {
	
	@Test
	public void TestShiftZero() {
		String input = "abcde";
		String shifted = "abcde";
		String notShifted = "edcba";
		
		assertTrue(isShiftedString(input, shifted));
		assertFalse(isShiftedString(input, notShifted));
	}
	
	@Test
	public void TestShiftMiddle() {
		String input = "abcde";
		String shifted = "cdeab";
		String notShifted = "edcba";
		
		assertTrue(isShiftedString(input, shifted));
		assertFalse(isShiftedString(input, notShifted));
	}
	
	@Test
	public void TestShiftLength() {
		String input = "abcde";
		String shifted = "eabcd";
		String notShifted = "edcba";
		
		assertTrue(isShiftedString(input, shifted));
		assertFalse(isShiftedString(input, notShifted));
	}

}

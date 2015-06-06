package stringManipulation;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestUniqueChars {

	@Test
	public void TestIterativeUnique(){
		final String unique = "abcdefg";
		assertTrue(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
	@Test
	public void TestIterativeRepeatedStart() {
		final String unique = "aaabcdefg";
		assertFalse(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
	@Test
	public void TestIterativeRepeatedEnds() {
		final String unique = "abcdefga";
		assertFalse(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
	@Test
	public void TestRecursiveUnique() {
		final String unique = "abcdefg";
		assertTrue(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
	@Test
	public void TestRecursiveRepeatedStart() {
		final String unique = "aaabcdefg";
		assertFalse(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
	@Test
	public void TestRecursiveRepeatedEnds() {
		final String unique = "abcdefga";
		assertFalse(UniqueChars.HasOnlyUniqueCharsIterative(unique));
	}
	
}

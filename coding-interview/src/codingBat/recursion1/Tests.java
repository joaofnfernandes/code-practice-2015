package codingBat.recursion1;

import org.junit.Test;
import static org.junit.Assert.*;
import static codingBat.recursion1.Implementations.*;

public class Tests {

	@Test
	public void TestFactorial() {
		int[] expected = new int[] {0,1,2,6,24,120};
		for(int i = 1; i < expected.length; i++) {
			assertEquals(expected[i], factorial(i));
		}
	}
	
	@Test
	public void TestBunnyEars2() {
		int[] expected = new int[] {0,2,5,7,10};
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], bunnyEars2(i));
		}
	}
	
	@Test
	public void TestCount7() {
		assertEquals(0, count7(1));
		assertEquals(0, count7(123456890));
		assertEquals(1, count7(1234567890));
		assertEquals(5, count7(712774577));
	}
	
	@Test
	public void TestCountX() {
		assertEquals(0, countX(""));
		assertEquals(0, countX("abcdefg !@#$%"));
		assertEquals(3, countX("xoxoxo"));
	}
	
	@Test
	public void TestChangePi() {
		assertEquals("xoxo", changePi("xoxo"));
		assertEquals("3.14xo", changePi("pixo"));
		assertEquals("3.14xo3.14", changePi("pixopi"));
	}
	
	@Test
	public void TestArray11() {
		assertEquals(0, array11(new int[] {}, 0));
		assertEquals(0, array11(new int[] {1,2,3,4,5,6}, 0));
		assertEquals(1, array11(new int[] {11}, 0));
		assertEquals(3, array11(new int[] {11,0,11,0,11}, 0));
	}
	
	@Test
	public void TestPairStar() {
		assertEquals("", pairStar(""));
		assertEquals("abcdef", pairStar("abcdef"));
		assertEquals("a*a*abc*c*cde*e*e", pairStar("aaabcccdeee"));
	}
	
	@Test
	public void TestCountAbc() {
		// no match
		assertEquals(0, countAbc(""));
		assertEquals(0, countAbc("ab"));
		assertEquals(0, countAbc("abd"));
		// one match
		assertEquals(1, countAbc("abc"));
		assertEquals(1, countAbc("aba"));
		// n matches
		assertEquals(2, countAbc("ababc"));
		assertEquals(4, countAbc("abcabaabcaba"));
	}
	
	@Test
	public void TestCountHi2() {
		assertEquals(0, countHi2("")); assertEquals(0, countHi2("abcde"));
		assertEquals(0, countHi2("xhi")); assertEquals(0, countHi2("xhixhi"));
		
		assertEquals(1, countHi2("hi"));
		assertEquals(1, countHi2("ahi"));
		assertEquals(1, countHi2("ahixhi"));
		
		assertEquals(2, countHi2("hihi"));
		assertEquals(2, countHi2("ahiahi"));
	}
	
	@Test
	public void TestStrCount() {
		assertEquals(0, strCount("abcde", "f"));
		assertEquals(3, strCount("fabfcdef", "f"));
		assertEquals(3, strCount("catcowcatdogcat", "cat"));
	}
	
	@Test
	public void TestBunnyEars() {
		assertEquals(0, bunnyEars(0));
		assertEquals(2, bunnyEars(1));
		assertEquals(4, bunnyEars(2));
		assertEquals(6, bunnyEars(3));
	}
	
	@Test
	public void TestTriangle() {
		assertEquals(0, triangle(0));
		assertEquals(1, triangle(1));
		assertEquals(3, triangle(2));
		assertEquals(6, triangle(3));
	}
	
	@Test
	public void TestCount8() {
		assertEquals(0, count8(123456));
		assertEquals(3, count8(8128348));
		assertEquals(9, count8(88888));
	}
	
	@Test
	public void TestCountHi() {
		assertEquals(0, countHi("")); assertEquals(0, countHi("abc"));
		assertEquals(1, countHi("hi"));
		assertEquals(3, countHi("hihihi")); assertEquals(3, countHi("hiahiahi"));
	}
	
	@Test
	public void TestNoX() {
		assertEquals("",noX(""));
		assertEquals("abcd",noX("abcd"));
		assertEquals("abcd",noX("xaxbxcxdx"));
	}
	
	@Test
	public void TestArray220() {
		assertEquals(false, array220(new int[] {}, 0));
		assertEquals(false, array220(new int[] {1,2,3,4,5}, 0));
		
		assertEquals(true, array220(new int[] {1,10,3,4,5}, 0));
		assertEquals(true, array220(new int[] {1,2,3,4,40}, 0));
	}
	
	@Test
	public void TestEndX() {
		assertEquals("", endX(""));
		assertEquals("abc", endX("abc"));
		assertEquals("abcxxxx", endX("xaxbxcx"));
	}
	
	@Test
	public void TestCount11() {
		assertEquals(0, count11(""));
		assertEquals(0, count11("123123"));
		assertEquals(1, count11("111"));
		assertEquals(5, count11("1111231141111"));
	}
	
	@Test
	public void TestParenBit() {
		assertEquals("", parenBit(""));
		assertEquals("", parenBit("abc"));
		assertEquals("(def)", parenBit("abc(def)ghi"));
	}
	
	@Test
	public void TestStrCopies() {
		assertEquals(false, strCopies("", "", 1));
		assertEquals(false, strCopies("catcow", "cat", 2));
		
		assertEquals(true, strCopies("iii", "ii", 2));
		assertEquals(true, strCopies("catcatcowcatcowcatcat", "", 5));
		
	}

	@Test
	public void TestFibonacci() {
		int[] expected = new int[] {0,1,1,2,3,5,8};
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], fibonacci(i));
		}
	}

	@Test
	public void TestSumNumbers() {
		assertEquals(9, sumDigits(126));
		assertEquals(13, sumDigits(49));
		assertEquals(3, sumDigits(12));
	}
	
	@Test
	public void TestPowerN() {
		assertEquals(3, powerN(3, 1));
		assertEquals(9, powerN(3, 2));
		assertEquals(27, powerN(3, 3));
	}
	
	@Test
	public void TestChangeXY() {
		assertEquals("aaa", changeXY("aaa"));
		assertEquals("yaybyc", changeXY("xaxbxc"));
	}
	
	@Test
	public void TestArray6() {
		assertEquals(false, array6(new int[] {1,2,3,4,5}, 0));
		assertEquals(true, array6(new int[] {6,1,2,3,4,5}, 0));
		assertEquals(true, array6(new int[] {1,2,3,4,5,6}, 0));
	}
	
	@Test
	public void TestAllStar() {
		assertEquals("a*b", allStar("ab"));
		assertEquals("h*e*l*l*o", allStar("hello"));
	}
	
	@Test
	public void TestCountPairs() {
		assertEquals(1, countPairs("axa"));
		assertEquals(1, countPairs("axabx"));
		assertEquals(2, countPairs("axax"));
	}
	
	@Test
	public void TestStringClean() {
		assertEquals("abc", stringClean("abc"));
		assertEquals("abc", stringClean("aaaabbbbbbccccc"));
		assertEquals("abab", stringClean("abbaab"));
	}
	
	@Test
	public void TestNestedParens() {
		assertEquals(false, nestParen("("));
		assertEquals(false, nestParen(")"));
		assertEquals(false, nestParen("(()"));
		
		assertEquals(true, nestParen("()"));
		assertEquals(true, nestParen("(((())))"));
	}
	
	@Test
	public void TestStrDist() {
		assertEquals(9, strDist("catcowcat", "cat"));
		assertEquals(3, strDist("catcowcat", "cow"));
		assertEquals(0, strDist("", "a"));
		assertEquals(0, strDist("xyz", "a"));
		assertEquals(9, strDist("cccatcowcatxx", "cat"));
		assertEquals(1, strDist("hiHellohihihi", "o"));
		assertEquals(13, strDist("hiHellohihihi", "hi"));
		assertEquals(5, strDist("hiHellohihihi", "hih"));
	}

	@Test
	public void TestGroupSum() {
		// No target
		assertFalse(groupSum(0, new int[] {}, 5));
		assertFalse(groupSum(0, new int[] {0}, 5));
		assertFalse(groupSum(0, new int[] {0,1,2,6}, 5));
		// One Target
		assertTrue(groupSum(0, new int[] {5}, 5));
		assertTrue(groupSum(0, new int[] {1,2,3}, 5));
		// Multiple Targets
		assertTrue(groupSum(0, new int[] {0,0,0,0,5,5,5,0,0}, 5));
		assertTrue(groupSum(0, new int[] {1,2,3,4}, 5));
	}

	@Test
	public void TestGroupSum5() {
		// No target
		assertFalse(groupSum5(0, new int[] {}, 5));
		assertFalse(groupSum5(0, new int[] {1,2,6}, 5));
		assertFalse(groupSum5(0, new int[] {1,2,6}, 5));
		assertFalse(groupSum5(0, new int[] {1,2,5,5}, 5));
		assertFalse(groupSum5(0, new int[] {5,1,10}, 6));
		// One target
		assertTrue(groupSum5(0, new int[] {5}, 5));
		assertTrue(groupSum5(0, new int[] {5,1,1}, 6));
		// Multiple targets
		assertTrue(groupSum5(0, new int[] {1,2,3,4}, 5));
		assertTrue(groupSum5(0, new int[] {5,1,5,1,10,1}, 20));
	}

	@Test
	public void TestSplitOdd10() {
		// Cannot split
		assertFalse(splitOdd10(new int[] {0}));
		assertFalse(splitOdd10(new int[] {1,1}));
		// Can split
		assertTrue(splitOdd10(new int[] {1}));
		assertTrue(splitOdd10(new int[] {5,10}));
		assertTrue(splitOdd10(new int[] {1,10,1,1}));
	}

	@Test
	public void TestGroupSum6() {
		// Can't sum
		assertFalse(groupSum6(0, new int[] {}, 10));
		assertFalse(groupSum6(0, new int[] {1,2,3}, 10));
		assertFalse(groupSum6(0, new int[] {6,6}, 6));
		// Can sum
		assertTrue(groupSum6(0, new int[] {1,2,3,4}, 5));
		assertTrue(groupSum6(0, new int[] {1,2,6,6}, 12));
	}
	
	@Test
	public void TestGroupSumClump() {
		// Can't sum
		assertFalse(groupSumClump(0, new int[] {}, 1));
		assertFalse(groupSumClump(0, new int[] {1,1,1}, 1));
		// Can sum
		assertTrue(groupSumClump(0, new int[] {1,2,1,1,1,1}, 2));
		assertTrue(groupSumClump(0, new int[] {1,2,1,1,1,1}, 4));
	}
	
	@Test
	public void TestSplit53() {
		// Can't split
		assertFalse(split53(new int[] {}));
		assertFalse(split53(new int[] {5}));
		assertFalse(split53(new int[] {3,3,   5,5}));
		// Can split
		assertTrue(split53(new int[] {2,3,    5}));
		assertTrue(split53(new int[] {3,3,    1,5}));
		assertTrue(split53(new int[] {1,2,3,  1,5}));
	}
	
	@Test
	public void TestGroupNoAdj() {
		// Can't sum
		assertFalse(groupNoAdj(0, new int[] {}, 10));
		assertFalse(groupNoAdj(0, new int[] {1}, 10));
		assertFalse(groupNoAdj(0, new int[] {9,1,2}, 10));
		// Can sum
		assertTrue(groupNoAdj(0, new int[] {10}, 10));
		assertTrue(groupNoAdj(0, new int[] {9,1,1}, 10));
		assertTrue(groupNoAdj(0, new int[] {9,1,9,1,1}, 10));
	}
	
	@Test
	public void TestSplitArray() {
		// Can't split
		assertFalse(splitArray(new int[] {1}));
		assertFalse(splitArray(new int[] {1,2}));
		// Can split
		assertTrue(splitArray(new int[] {}));
		assertTrue(splitArray(new int[] {1,2,3}));
	}
}

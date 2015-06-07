package removeSpaces;

import org.junit.Test;
import static org.junit.Assert.*;
import static removeSpaces.RemoveSpaces.*;

public class TestRemoveSpaces {
	
	@Test
	public void TestRemoveSpacesIter() {
		char[] s1 = "abc\0".toCharArray();
		char[] s1Expected = "abc\0".toCharArray();
		
		char[] s2 = "  abc\0".toCharArray();
		char[] s2Expected = "%20%20abc\0".toCharArray();
		
		char[] s3 = "abc  \0".toCharArray();
		char[] s3Expected = "abc%20%20\0".toCharArray();
		
		char[] s4 = "  a b  c  \0".toCharArray();
		char[] s4Expected = "%20%20a%20b%20%20c%20%20\0".toCharArray();
		
		assertEquals(new String(s1Expected), new String(removeSpacesIter(s1, s1.length)));
		assertEquals(new String(s2Expected), new String(removeSpacesIter(s2, s2.length)));
		assertEquals(new String(s3Expected), new String(removeSpacesIter(s3, s3.length)));
		assertEquals(new String(s4Expected), new String(removeSpacesIter(s4, s4.length)));
	}
	
	@Test
	public void TestRemoveSpacesRecursive() {
		char[] s1 = "abc\0".toCharArray();
		char[] s1Expected = "abc\0".toCharArray();
		
		char[] s2 = "  abc\0".toCharArray();
		char[] s2Expected = "%20%20abc\0".toCharArray();
		
		char[] s3 = "abc  \0".toCharArray();
		char[] s3Expected = "abc%20%20\0".toCharArray();
		
		char[] s4 = "  a b  c  \0".toCharArray();
		char[] s4Expected = "%20%20a%20b%20%20c%20%20\0".toCharArray();
		
		assertEquals(new String(s1Expected), new String(removeSpacesRecursive(s1, s1.length)));
		assertEquals(new String(s2Expected), new String(removeSpacesRecursive(s2, s2.length)));
		assertEquals(new String(s3Expected), new String(removeSpacesRecursive(s3, s3.length)));
		assertEquals(new String(s4Expected), new String(removeSpacesRecursive(s4, s4.length)));
	}
	

}

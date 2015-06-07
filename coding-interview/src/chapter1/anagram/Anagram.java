package chapter1.anagram;

import java.util.Arrays;

public class Anagram {
	public static boolean isAnagram(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		return new String(c1).equals(new String(c2));
	}
}

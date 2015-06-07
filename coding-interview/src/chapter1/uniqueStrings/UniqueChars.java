package chapter1.uniqueStrings;

import java.util.Arrays;

public class UniqueChars {
	
	public static boolean HasOnlyUniqueCharsIterative(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		for(int i = 0; i < s.length() - 1; i++) {
			if(chars[i] == chars[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean HasOnlyUniqueCharsRecursive(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return recurse(chars, 0);
	}
	
	private static boolean recurse(char[] chars, int i) {
		if(i > chars.length - 1) {
			return true;
		}
		return chars[i] != chars[i + 1] && recurse(chars, i++);
	}

}

package chapter1.shiftedString;

import java.util.ArrayList;

//TODO: we don't need all this mess. If s2 is substring of s1+s1, then its a rotation
public class ShiftedString {
	
	public static boolean isShiftedString(String s1, String s2) {
		if(s1 == null || s2 == null ||
				s1.isEmpty() && !s2.isEmpty() ||
				!s1.isEmpty() && s2.isEmpty()) {
			return false;
		}
		
		ArrayList<Integer> possibleShiftBy = findCharOccurrences(s2, s1.charAt(0));
		for(int index : possibleShiftBy) {
			boolean isShiftedString = isShiftedString(s1, s2, index);
			if(isShiftedString) {
				return true;
			}
		}
		return false;
	}
	
	private static ArrayList<Integer> findCharOccurrences(String s, char c) {
		ArrayList<Integer> occurences = new ArrayList<Integer>();
		int index = s.indexOf(c, 0);
		while(index > -1) {
			occurences.add(index);
			index = s.indexOf(c, index + 1);
		}
		return occurences;
	}
	
	private static boolean isShiftedString(String s1, String s2, int shiftBy) {
		return s1.equals(rotateNoBuffer(s2, shiftBy));
	}
	
	//shifts a string using a buffer	
	private static String rotateWithBuffer(String s, int shiftBy) {
		char[] oldArr = s.toCharArray();
		char[] newArr = new char[s.length()];
		int i,j = 0;
		for(i = 0, j = shiftBy; j < oldArr.length; i++, j++) {
			newArr[i] = oldArr[j];
		}
		for(j = 0; i < newArr.length; i++, j++) {
			newArr[i] = oldArr[j];
		}
		return new String(newArr);
	}
	
	// Shifts a string without requiring a buffer
	private static String rotateNoBuffer(String s, int shiftBy) {
		char[] array = s.toCharArray();
		int first = 0;
		int last = s.length();
		int next = shiftBy;
		
		while(first != next) {
			swap(array, first++, next++);
			if(next == last) {
				next = shiftBy;
			} else {
				if(first == shiftBy) {
					shiftBy = next;
				}
			}
		}
		return new String(array);
	}
	
	private static void swap(char[] c, int i, int j) {
		char aux = c[i];
		c[i] = c[j];
		c[j] = aux;
	}

}

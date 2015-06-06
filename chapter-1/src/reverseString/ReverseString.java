package reverseString;

public class ReverseString {
	
	public static void reverseIterative(char[] s, int length) {
		for(int i = 0; i < (length - 1) / 2; i++) {
			swap(s, i, length - 2 - i );		
		}
	}
	
	public static void reverseRecursive(char[] s, int length) {
		recurse(s, length, 0);
		
	}
	
	private static void recurse(char[] s, int length, int i) {
		if (i > (length - 2) / 2) {
			return;
		} else {
			swap(s, i, length - 2 - i );			
			recurse(s, length, i + 1);
		}
	}
	
	private static void swap(char[] s, int i, int j) {
		char aux = s[i];
		s[i] = s[j];
		s[j] = aux;
	}
	
	
}
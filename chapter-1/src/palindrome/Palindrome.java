package palindrome;

//TODO: support spaces between chars
public class Palindrome {
	
	public static boolean isPalindromeIterative(String s) {
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromeRecursive(String s) {
		return recurse(s, 0);
	}
	
	private static boolean recurse(String s, int i) {
		if (i > s.length() / 2) {
			return true;
		} else {
			return s.charAt(i) == s.charAt(s.length() - 1 - i) &&
					recurse(s, i + 1);
		}
	}

}

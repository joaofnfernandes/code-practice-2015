package removeDuplicates;

public class RemoveDuplicates {
	
	public static void removeIterative(char[] s, int length) {
		// invariant: chars on the left have no duplicates
		int i, totalAccumulated = 0;
		for(i = 0; i < length - 1 - totalAccumulated; i++) {
			int accumulated = 0;
			for(int j = i + 1; j < length - 1 - totalAccumulated; j++ ) {
				if(s[i] == s[j]) {
					accumulated++;
				} else {
					s[j - accumulated] = s[j];
				}
			}
			totalAccumulated += accumulated;
		}
		
		for(; i < length - 1; i++) {
			s[i] = '\0';
		}
		
	}

}

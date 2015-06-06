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
	
	public static void removeRecursive(char[] s, int length) {
		recurseI(s, length, 0, 0);
	}
	
	private static void recurseI(char[] s, int length, int i, int totalAccumulated) {
		if(i > length - 1 - totalAccumulated) {
			padWithZeros(s, length, i);
			return;
		} else {
			totalAccumulated += recurseJ(s, length, i, i + 1, totalAccumulated, 0);
			recurseI(s, length, i + 1, totalAccumulated);
		}
		
	}
	
	private static int recurseJ(char[] s, int length, int i, int j, int totalAccumulated, int localAccumulated) {
		if (j > length - 1 - totalAccumulated) {
			return localAccumulated;
		} else {
			if(s[i] == s[j]) {
				localAccumulated++;
			} else {
				s[j - localAccumulated] = s[j];
			}
			localAccumulated = recurseJ(s, length, i, j + 1, totalAccumulated, localAccumulated);
			return localAccumulated;
		}
	}

	// pads a string with \0 to the end
	private static void padWithZeros(char s[], int length, int i) {
		if(i > length - 1) {
			return;
		} else {
			s[i] = '\0';
			padWithZeros(s, length, i + 1);
		}
	}
}

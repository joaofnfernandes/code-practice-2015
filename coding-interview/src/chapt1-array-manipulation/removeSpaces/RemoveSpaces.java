package removeSpaces;

//TODO: can we do it in a single pass?
public class RemoveSpaces {

	public static char[] removeSpacesIter(char[] s, int length) {
		int spaces = 0;
		for(int i = 0; i < length - 1; i++) {
			if (s[i] == ' ') {
				spaces++;
			}
		}
		int newLength = length - spaces + 3 * spaces;
		char[] result = new char[newLength];
		result[newLength - 1] = '\0';
		
		for(int i = 0, j = 0; i < length - 1 || j < newLength - 1; i++, j++) {
			if(s[i] != ' ') {
				result[j] = s[i];
			} else {
				result[j] = '%';
				result[j + 1] = '2';
				result[j + 2] = '0';
				j += 2;
			}
		}
		return result;
	}
	
	public static char[] removeSpacesRecursive(char[] s, int length) {
		int spaces = countSpaces(s, length);
		int newLength = length - spaces + 3 * spaces;
		char[] result = new char[newLength];
		result[newLength - 1] = '\0';
		replaceSpaces(s, length, result, newLength);
		return result;
		
	}
	
	private static int countSpaces(char[] s, int length) {
		return countSpacesRecurse(s, length, 0, 0);
	}
	
	private static int countSpacesRecurse(char[] s, int length, int i, int spaceCount) {
		if(i > length - 1) {
			return spaceCount;
		} else {
			if(s[i] == ' ') {
				spaceCount++;
			}
			spaceCount = countSpacesRecurse(s, length, i + 1, spaceCount);
			return spaceCount;
		}
	}
	
	private static void replaceSpaces(char[] oldString, int oldLength, char[] newString, int newLength) {
		replaceSpaces(oldString, oldLength, newString, newLength, 0, 0);
	}
	
	private static void replaceSpaces(char[] oldString, int oldLength, char[] newString, int newLength, int i, int j) {
		if(i > oldLength - 1 || j > newLength - 1) {
			return;
		} else {
			if(oldString[i] != ' ') {
				newString[j] = oldString[i];
			} else {
				newString[j] = '%';
				newString[j + 1] = '2';
				newString[j + 2] = '0';
				j += 2;
			}
		replaceSpaces(oldString, oldLength, newString, newLength, i + 1, j + 1);
		}
	}
}

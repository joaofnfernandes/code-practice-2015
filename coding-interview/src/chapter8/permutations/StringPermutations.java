package chapter8.permutations;

import java.util.ArrayList;

public class StringPermutations {
	
	private String str;
	private ArrayList<String> permutations = new ArrayList<String>();
	
	public StringPermutations(String str) {
		this.str = str;
	}
	
	public String GetPermutations() {
		getPermutations(str, "");
		return permutations.toString();
	}
	
	private void getPermutations(String originalStr, String permutationSoFar) {
		if(originalStr.isEmpty()) {
			permutations.add(permutationSoFar);
		} else {
			for(int i = 0; i < originalStr.length(); i++) {
				getPermutations(originalStr.substring(0, i) + originalStr.substring(i + 1, originalStr.length()),
						permutationSoFar + originalStr.charAt(i));
			}
		}
	}
	

}

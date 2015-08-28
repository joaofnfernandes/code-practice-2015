package chapter8.parensCombination;

import java.util.HashSet;

public class Parens {
	private int count;
	private HashSet<String> parensCombinations = new HashSet<String>();
	
	public Parens(int N) {
		this.count = N;
	}
	
	public String GetCombinations() {
		getCombinations(count, "");
		String result = parensCombinations.toString();
		return result.substring(1, result.length() - 1);
	}
	
	private void getCombinations(int count, String parensSoFar) {
		if(count == 0) {
			parensCombinations.add(parensSoFar);
		} else if(count == 1) {
			getCombinations(count - 1, "(" + parensSoFar + ")");
		} else {
			// Try all paths: ()abc | (abc) | abc()
			getCombinations(count - 1, "()" + parensSoFar);
			getCombinations(count - 1, "(" + parensSoFar + ")");
			getCombinations(count - 1, parensSoFar + "()");
		}
	}

}

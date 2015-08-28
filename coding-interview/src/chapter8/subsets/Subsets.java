package chapter8.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	private ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
	private List<Integer> set;
	
	public Subsets(List<Integer> set) {
		this.set = set;
	}
	
	public String GetSubsets() {
		getSubset(0,new ArrayList<Integer>());
		return subsets.toString();
	}
	
	private void getSubset(int index, ArrayList<Integer> currSet) {
		if(currSet == null || index > set.size()) {
			return;
		} if(index == set.size()) {
			if(!currSet.isEmpty()) { subsets.add(currSet); }
		} else {
			// Explore path where number is used
			ArrayList<Integer> subset1 = new ArrayList<>(currSet);
			subset1.add(set.get(index));
			getSubset(index + 1, subset1);

			// And path where number not used
			getSubset(index + 1, new ArrayList<>(currSet));
		}
	}
	
}
	
package chapter8.makeChange;

import java.util.TreeSet;
import chapter8.makeChange.Change.CoinType;;

public class MakeChange {

	private TreeSet<Change> changeCombinations = new TreeSet<Change>(new ChangeComparator());
	
	public String GetChange(int value) {
		getChange(value, new Change());
		return changeCombinations.toString();
	}
	
	private void getChange(int target, Change changeSoFar) {
		if(target < 0) {
			return;
		} else if(target == 0) {
			changeCombinations.add(changeSoFar);
			return;
		} else {
			// Try all possible paths
			Change newChange;
			for(CoinType coinType : CoinType.values()) {
				newChange = new Change(changeSoFar);
				newChange.AddCoin(coinType);
				
				getChange(target - coinType.value, newChange);
			}
		}
	}
	
}

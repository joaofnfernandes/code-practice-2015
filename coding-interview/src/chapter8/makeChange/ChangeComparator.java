package chapter8.makeChange;

import java.util.Comparator;

public class ChangeComparator implements Comparator<Change> {

	@Override
	public int compare(Change c1, Change c2) {
		if(c1 == null) {
			if(c2 == null){ return 1;} else {return -1;}
		} else if(c2 == null) {
			return 1;
		} else {
			return c1.compareTo(c2);
		}
	}

}

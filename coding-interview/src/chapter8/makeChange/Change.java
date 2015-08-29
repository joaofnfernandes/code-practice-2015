package chapter8.makeChange;

public class Change implements Comparable<Change> {

	public enum CoinType {
		QUARTER(25, 0),
		TEN(10, 1),
		ONE(1, 2);
		
		private int coinSlot;
		public int value;
		private CoinType(int value, int slot){
			this.value = value;
			this.coinSlot = slot;
		}
	}
	
	private int[] coinSlots = new int[CoinType.values().length];
	private int total = 0;
	
	public Change() {
		for(int i = 0; i < coinSlots.length; i++) {
			coinSlots[i] = 0;
		}
	}
	public Change(Change change) {
		this.total = change.total;
		for(int i = 0; i < coinSlots.length; i++) {
			coinSlots[i] = change.coinSlots[i];
		}
	}
	

	public int GetTotal() {
		return total;
	}
	
	public void AddCoin(CoinType coinType) {
		coinSlots[coinType.coinSlot] += 1;
		total = total + coinType.value;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		
		for(int i = 0; i < coinSlots.length; i++) {
			builder.append(coinSlots[i]);
			if(i < coinSlots.length - 1) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	
	@Override
	public int compareTo(Change other) {
		if(other == null) {
			return 1;
		} else if(this == other) {
			return 0;
		} else {
			for(int i = 0; i < coinSlots.length; i++) {
				if(this.coinSlots[i] < other.coinSlots[i]) {
					return -1;
				} if(this.coinSlots[i] > other.coinSlots[i]) {
					return 1;
				}
			}
			return 0;
		}
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass().getSimpleName() != this.getClass().getSimpleName()) {
			return false;
		} else {
			return this.compareTo((Change) obj) == 0;
		}
	}
	
	
}

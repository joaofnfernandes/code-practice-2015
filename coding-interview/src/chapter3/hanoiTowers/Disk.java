package chapter3.hanoiTowers;

public class Disk implements Comparable<Disk>{
	public int Value;
	
	public Disk(int value) {
		this.Value = value;
	}

	@Override
	public int compareTo(Disk that) {
		if (that == null) {
			return 1;
		} else if(that == this) {
			return 0;
		} else {
			int result = this.Value - that.Value;
			return result == 0 ? 0 : result > 0 ? 1 : -1;
		}
	}
	
	public String toString() {
		return new Integer(Value).toString();
	}
	
	
}

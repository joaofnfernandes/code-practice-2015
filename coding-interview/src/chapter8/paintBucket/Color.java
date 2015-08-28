package chapter8.paintBucket;

public enum Color {
	RED("R"),
	GREEN("G");
	
	private String value;
	private Color(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}

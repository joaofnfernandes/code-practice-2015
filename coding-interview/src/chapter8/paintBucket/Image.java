package chapter8.paintBucket;

public class Image implements Comparable<Image> {

	private int size;
	private Color[][] colorMatrix;
	
	public Image(int size, Color initialColor) {
		this.size = size;
		colorMatrix = new Color[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				colorMatrix[i][j] = initialColor;
			}
		}
	}
	
	public Color[][] GetColorMatrix() {
		return colorMatrix;
	}
	
	public void InvertColors() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(colorMatrix[i][j] == Color.RED) {
					colorMatrix[i][j] = Color.GREEN;
				} else {
					colorMatrix[i][j] = Color.RED;
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < size; i++) {
			builder.append("[");
			for(int j = 0; j < size; j++) {
				builder.append(colorMatrix[i][j].toString());
			}
			builder.append("]");
			if(i < size - 1) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}

	@Override
	public int compareTo(Image other) {
		if(other == null) {
			return 1;
		} else if(this == other) {
			return 0;
		} else {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(!colorMatrix[i][j].equals(other.colorMatrix[i][j])) {
						return 1;
					}
				}
			}
			return 0;
		}
	}


	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
			return this.compareTo((Image)obj) == 0;
		}
		return false;
	}
 
	
}

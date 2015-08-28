package chapter8.paintBucket;

public class PaintBucketCommand implements PixelCommand {
	
	private Color color;
	
	public PaintBucketCommand(Color color) {
		this.color = color;
	}
	
	public void SetBrushColor(Color color) {
		this.color = color;
	}

	@Override
	public void Apply(Image img, int i, int j) {
		Color[][] colorMatrix = img.GetColorMatrix();
		paint(img, i, j, colorMatrix[i][j], color);
	}
	
	private void paint(Image img, int i, int j, Color from, Color to) {
		Color[][] colorMatrix = img.GetColorMatrix();
		if(i < 0 || i >= colorMatrix.length || j < 0 || j >= colorMatrix.length) {
			return;
		} else if(colorMatrix[i][j] != from) {
			return;
		} else {
			colorMatrix[i][j] = to;
			
			paint(img, i - 1, j, from, to); // Top
			paint(img, i - 1, j + 1, from, to); // Top-right
			paint(img, i, j + 1, from, to); // Right
			paint(img, i + 1, j + 1, from, to); // Bottom-Right
			paint(img, i + 1, j, from, to); // Bottom
			paint(img, i + 1, j - 1, from, to); // Bottom-left
			paint(img, i, j - 1, from, to); // Left
			paint(img, i - 1, j - 1, from, to); // Top-left
		}
	}

	
}

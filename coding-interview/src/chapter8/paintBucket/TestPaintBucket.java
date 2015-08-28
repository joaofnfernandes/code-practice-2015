package chapter8.paintBucket;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPaintBucket {
	
	private static final int IMAGE_SIZE = 3;
	private static final Color BACKGROUND= Color.RED;
	private static final Color FOREGROUND = Color.GREEN;
	
	@Test
	public void TestPaintOnePixel() {
		// Try painting center pixel with RED of an image with fg=RED centerPx=GREEN
		Image expectedImage = new Image(IMAGE_SIZE, BACKGROUND);
		
		Image resultImage = makeImageWithCenterPixel(IMAGE_SIZE, BACKGROUND, FOREGROUND);
		
		PixelCommand paintBucket = new PaintBucketCommand(BACKGROUND);
		int centerPixel = (IMAGE_SIZE - 1) / 2;
		paintBucket.Apply(resultImage, centerPixel, centerPixel); // Paint center pixel
				
		assertEquals(expectedImage, resultImage);
	}
	
	@Test
	public void TestPaintCross() {
		// Try painting center pixel with RED of an image with cross=Green
		Image expectedImage = new Image(IMAGE_SIZE, BACKGROUND);
		
		Image resultImage = makeImageWithCenterCross(IMAGE_SIZE, BACKGROUND, FOREGROUND);
		PixelCommand paintBucket = new PaintBucketCommand(BACKGROUND);
		
		int centerPixel = (IMAGE_SIZE - 1) / 2;
		paintBucket.Apply(resultImage, centerPixel, centerPixel); // Paint center pixel
		
		assertEquals(expectedImage, resultImage);
	}
	
	@Test
	public void TestPaintDiagonal() {
		// Try painting center pixel with RED of an image with Diagonal=Green
		Image expectedImage = new Image(IMAGE_SIZE, BACKGROUND);
		
		Image resultImage = makeImageWithDiagonal(IMAGE_SIZE, BACKGROUND, FOREGROUND);
		PixelCommand paintBucket = new PaintBucketCommand(BACKGROUND);
		
		int centerPixel = (IMAGE_SIZE - 1) / 2;
		paintBucket.Apply(resultImage, centerPixel, centerPixel); // Paint center pixel
		
		assertEquals(expectedImage, resultImage);
	}
	
	@Test
	public void TestPaintAllPixels() {
		// Try painting center pixel with RED of an image with all Green
		Image expectedImage = new Image(IMAGE_SIZE, BACKGROUND);
		
		Image resultImage = new Image(IMAGE_SIZE, FOREGROUND);
		PixelCommand paintBucket = new PaintBucketCommand(BACKGROUND);
		
		int centerPixel = (IMAGE_SIZE - 1) / 2;
		paintBucket.Apply(resultImage, centerPixel, centerPixel); // Paint center pixel
		
		assertEquals(expectedImage, resultImage);
	}
	
	
	private Image makeImageWithCenterPixel(int size, Color background, Color foreground) {
		Image img = new Image(size, background);
		Color[][] colorMatrix = img.GetColorMatrix();
		int pixel = (size - 1) / 2;
		colorMatrix[pixel][pixel] = foreground;
		return img;
	}
	
	private Image makeImageWithCenterCross(int size, Color background, Color foreground) {
		Image img = new Image(size, background);
		Color[][] colorMatrix = img.GetColorMatrix();
		int center = (size - 1) / 2;
		
		colorMatrix[center][center] = foreground; // center
		colorMatrix[center - 1][center] = foreground; // Top
		colorMatrix[center][center + 1] = foreground; // Right
		colorMatrix[center + 1][center] = foreground; // Bottom
		colorMatrix[center][center - 1] = foreground; // Left
		
		return img;
	}

	private Image makeImageWithDiagonal(int size, Color background, Color foreground) {
		Image img = new Image(size, background);
		Color[][] colorMatrix = img.GetColorMatrix();
		for(int i = 0; i < colorMatrix.length; i++) {
			colorMatrix[i][i] = foreground;
		}
		return img;
	}
}

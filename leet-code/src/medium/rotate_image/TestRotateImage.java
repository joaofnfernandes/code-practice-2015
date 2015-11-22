package medium.rotate_image;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRotateImage {

    @Test
    public void testImage2X2() {
        int m = 2, n = 2;
        int[][] image = makeDefaultImage(m, n);
        int[][] expected = make90DegreeImage(m, n);
        new Solution().rotate(image);
        assertTrue(isSameImage(expected, image));
    }
    
    @Test
    public void testImage3X3() {
        int m = 3, n = 3;
        int[][] image = makeDefaultImage(m, n);
        int[][] expected = make90DegreeImage(m, n);
        new Solution().rotate(image);
        assertTrue(isSameImage(expected, image));
    }
    
    @Test
    public void testImage4X4() {
        int m = 4, n = 4;
        int[][] image = makeDefaultImage(m, n);
        int[][] expected = make90DegreeImage(m, n);
        new Solution().rotate(image);
        assertTrue(isSameImage(expected, image));
    }
    
    private int[][] makeDefaultImage(int m, int n) {
        int[][] img = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] = i * m + j;
            }
        }
        return img;
    }
    
    private int[][] make90DegreeImage(int m, int n) {
        int[][] img = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                img[i][j] = i + n * (n - 1 - j);
            }
        }
        return img;
    }
    
    private boolean isSameImage(int[][] img1, int[][] img2) {
        if(img1.length != img2.length) {
            return false;
        }
        for (int i = 0; i < img1.length; i++) {
            if(img1[i].length != img2[i].length) {
                return false;
            }
            for (int j = 0; j < img1[i].length; j++) {
                if(img1[i][j] != img2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

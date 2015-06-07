package chapter1.matrixManipulation;

public class MatrixManipulation {

	public static void rotate90Right(int[][] matrix) {
		leftDiagFlip(matrix);
		verticalMirror(matrix);
	}
	
	public static void rotate90Left(int[][] matrix) {
		rightDiagFlip(matrix);
		verticalMirror(matrix);
	}
	
	
	private static void verticalMirror(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int aux = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = aux;
			}
		}
	}
	
	private static void horizontalMirror(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int aux = matrix[i][j];
				matrix[i][j] = matrix[matrix.length -1 - i][j];
				matrix[i][matrix.length - 1] = aux;
			}
		}
	}

 	private static void leftDiagFlip(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix.length; j++) {
				int aux = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = aux;
			}
		}
	}
	
	private static void rightDiagFlip(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length - i; j++) {
				int k = matrix.length - 1 - j;
				int w = matrix.length - 1 - i; 
				int aux = matrix[i][j];
				matrix[i][j] = matrix[k][w];
				matrix[k][w] = aux;
			}
			
		}
	}
}

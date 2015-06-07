package zeroMatrix;

import java.util.HashSet;


// TODO: how can we make it even faster, by only scanning j's that we know don't have zero?
public class ZeroMatrix {

	public static void zero(int[][] matrix) {
		HashSet<Integer> rowSet = new HashSet<>();
		HashSet<Integer> colSet = new HashSet<>();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
					break;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}

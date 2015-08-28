package chapter8.matrixTransversal;

import java.util.ArrayList;

public class MatrixTransversal {

	private int[][] matrix = null;
	private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	
	public MatrixTransversal(int N) {
		matrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				matrix[i][j] = i * N + j; 
			}
		}
	}
	
	public String Transverse() {
		transverse(0, 0, new ArrayList<Integer>());
		return paths.toString();
	}
	
	private void transverse(int i, int j, ArrayList<Integer> currentPath) {
		if(currentPath == null) {
			return;	
		} else {
			// Add current cell to explored path, and explore all directions from here
			currentPath.add(matrix[i][j]);
			
			// up
			if(canGo(i, j, Direction.UP, currentPath)) {
				transverse(i - 1, j, new ArrayList<Integer>(currentPath));
			} 
			// right
			if(canGo(i, j, Direction.RIGHT, currentPath)) {
				transverse(i, j + 1, new ArrayList<Integer>(currentPath));
			}
			// down
			if(canGo(i, j, Direction.DOWN, currentPath)) {
				transverse(i + 1, j, new ArrayList<Integer>(currentPath));
			}
			// left
			if(canGo(i, j, Direction.LEFT, currentPath)) {
				transverse(i, j - 1, new ArrayList<Integer>(currentPath));
			}
			
			// Don't have anywhere to go, check if transversed all the board
			if(currentPath.size() == matrix.length * matrix.length) {
				paths.add(currentPath);
			}
		}
	}
	
	private enum Direction {
		UP,
		RIGHT,
		DOWN,
		LEFT
	}
	
	private boolean canGo(int i, int j, Direction direction, ArrayList<Integer> visited) {
		switch (direction) {
		case UP:
			return canGoUP(i, j, visited);
		case RIGHT:
			return canGoRight(i, j, visited);
		case DOWN:
			return canGoDown(i, j, visited);
		case LEFT:
			return canGoLeft(i, j, visited);
		default:
			throw new IllegalArgumentException("Trying to check for an invalid direction");
		}
	}
	
	private boolean canGoUP(int i, int j, ArrayList<Integer> visited){
		return i > 0 && !visited.contains(matrix[i - 1][j]);
	}
	private boolean canGoRight(int i, int j, ArrayList<Integer> visited){
		return j < matrix.length - 1 && !visited.contains(matrix[i][j + 1]);
	}
	private boolean canGoDown(int i, int j, ArrayList<Integer> visited){
		return i < matrix.length - 1 && !visited.contains(matrix[i + 1][j]);
	}
	private boolean canGoLeft(int i, int j, ArrayList<Integer> visited){
		return j > 0 && !visited.contains(matrix[i][j - 1]);
	}
	
	
}

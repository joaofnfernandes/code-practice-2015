package chapter8.queens;

import java.util.ArrayList;
import java.util.Comparator;

public class Board implements Comparable<Board> {
	
	private int N;
	private int queens;
	private boolean[][] cells;
	
	
	public Board(int N) {
		this.N = N;
		queens = 0;
		cells = new boolean[N][N];
	}
	
	public int Size() {
		return N;
	}

	public void AddQueen(int i, int j) {
		if(i < 0 || i >= N || j < 0 || j >= N) {
			return;
		} else {
			if(!cells[i][j]) {
				cells[i][j] = true;
				queens++;
			}
		}
	}
	
	public int QueenCount() {
		return queens;
	}
	
	public boolean CanAddQueen(int i, int j) {
		return !(cells[i][j] || hasQueenOnRow(i) || hasQueenOnColumn(j) || hasQueenOnDiagonals(i, j));
	}

	@Override
	public int compareTo(Board other) {
		if(other == null) {
			return 1;
		} else {
			if(this.N < other.N) {
				return -1;
			} else if(this.N > other.N) {
				return 1;
			} else {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(this.cells[i][j] != other.cells[i][j]) {
							return -1;
						}
					}
				}
				return 0;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass().getSimpleName() != this.getClass().getSimpleName()) {
			return false;
		} else {
			return this.compareTo((Board) obj) == 0;
		}
	}

	public ArrayList<Pair<Integer, Integer>> GetFreeCells() {
		ArrayList<Pair<Integer,Integer>> freeCells = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!cells[i][j]) {
					freeCells.add(new Pair<Integer, Integer>(i, j));
				}
			}
		}
		return freeCells;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			builder.append("[");
			for (int j = 0; j < N; j++) {
				if(cells[i][j]) {
					builder.append("Q");
				} else {
					builder.append("_");
				}
			}
			builder.append("]");
		}
		return builder.toString();
	}

	@Override
	protected Board clone() {
		Board clone = new Board(this.N);
		clone.queens = this.queens;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				clone.cells[i][j] = this.cells[i][j];
			}
		}
		return clone;
	}



	public static class BoardComparator implements Comparator<Board> {

		@Override
		public int compare(Board b1, Board b2) {
			return b1.compareTo(b2);
		}

		
		
	}

	private boolean hasQueenOnRow(int i) {
		for(int j = 0; j < N; j++) {
			if(cells[i][j]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasQueenOnColumn(int j) {
		for(int i = 0; i < N; i++) {
			if(cells[i][j]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasQueenOnDiagonals(int i, int j) {
		return hasQueenLeftDiagonal(i, j) || hasQueenRightDiagonal(i, j);
	}
	
	// \diag
	// TODO simplify - use a single for
	private boolean hasQueenLeftDiagonal(int i, int j) {
		// Check below (i,j)
		int k ,l;
		for(k =  + 1, l = j + 1; k < N && l < N; k++, l++) {
			if(cells[k][l]) {
				return true;
			}
		}
		// Check top (i,j)
		for(k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
			if(cells[k][l]) {
				return true;
			}
		}
		return false;
	}
	// /diag
	// TODO: simplify - use a single for
	private boolean hasQueenRightDiagonal(int i, int j) {
		// Check below (i,j)
		int k ,l;
		for(k = i + 1, l = j - 1; k < N && l >= 0; k++, l--) {
			if(cells[k][l]) {
				return true;
			}
		}
		// Check top (i,j)
		for(k = i - 1, l = j + 1; k >= 0 && l < N; k--, l++) {
			if(cells[k][l]) {
				return true;
			}
		}
		return false;
	}

	

}

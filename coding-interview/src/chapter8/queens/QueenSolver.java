package chapter8.queens;

import java.util.TreeSet;

public class QueenSolver {

	private TreeSet<Board> validSolutions = new TreeSet<Board>(new Board.BoardComparator());
	private Board board;
	
	public QueenSolver(int N) {
		board = new Board(N);
	}
	
	public String Solve() {
		for (int i = 0; i < board.Size(); i++) {
			Board currentBoard;
			for (int j = 0; j < board.Size(); j++) {
				currentBoard = board.clone();
				currentBoard.AddQueen(i, j);
				
				solve(currentBoard);
			}
		}
		return validSolutions.toString();
	}
	
	private void solve(Board currentBoard) {
		// explore all paths
		Board newBoard;
		int pathsExplored = 0;
		for(Pair<Integer, Integer> cell : currentBoard.GetFreeCells()) {
			if(currentBoard.CanAddQueen(cell.i, cell.j)) {
				pathsExplored++;
				newBoard = currentBoard.clone();
				newBoard.AddQueen(cell.i, cell.j);
				
				solve(newBoard);
			}
		}
		if(pathsExplored == 0) {
			validSolutions.add(currentBoard);
		}
	}
}

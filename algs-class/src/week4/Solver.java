package week4;

import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
 * Corner cases.  The constructor should throw a java.lang.NullPointerException if passed a null argument.
 */
public class Solver {
    private static final boolean HAMMING = false;

    private boolean hasSolution = false;
    private int movesToSolution = 0;
    private Stack<Board> solutionBoards;
    
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if(initial == null) {
            throw new NullPointerException("Null board in Solver constructor");
        }
        solveBoardAndTwin(initial);
    }
    
    // Solve a board and its twin at the same time
    private void solveBoardAndTwin(Board board) {
        Board originalBoard = board;
        Board twinBoard = board.twin();
        
        // Priority queues with nodes not explored yet
        MinPQ<SearchNode> searchNodesOriginal = new MinPQ<>(new SearchNodeComparator());
        MinPQ<SearchNode> searchNodesTwin = new MinPQ<>(new SearchNodeComparator());
        
        // Add initial board and its twin to priority queues, with 0 moves and no previous
        searchNodesOriginal.insert(new SearchNode(originalBoard, 0, null));
        searchNodesTwin.insert(new SearchNode(twinBoard, 0, null));
        
        SearchNode nodeFromOriginalQueue, nodeFromTwinQueue;
        
        while(!searchNodesOriginal.isEmpty() || !searchNodesTwin.isEmpty()) {
            // pick next nodes to explore
            nodeFromOriginalQueue = searchNodesOriginal.delMin();
            nodeFromTwinQueue = searchNodesTwin.delMin();
            
            // check if we reached a solution
            if(nodeFromOriginalQueue.board.isGoal()) {
                this.hasSolution = true;
                this.movesToSolution = nodeFromOriginalQueue.moves;
                updateSolutionBoards(nodeFromOriginalQueue);
                return;
            }
            if(nodeFromTwinQueue.board.isGoal()) {
                // If the twin board has a solution, the original isn't solvable
                this.hasSolution = false;
                this.movesToSolution = -1;
                this.solutionBoards = null;
                return;
            }
            
            // Generate nodes to explore, and add them to queue
            addNeighborsToExplore(nodeFromOriginalQueue, searchNodesOriginal);
            addNeighborsToExplore(nodeFromTwinQueue, searchNodesTwin);
        }
        
    }
    
    private void addNeighborsToExplore(SearchNode node, MinPQ<SearchNode> toExploreQueue) {
        SearchNode newSearchNode;
        for(Board neighborBoard : node.board.neighbors()) {
            // Don't enqueue boards same as grandparent
            if(node.previous == null ||
                    (node.previous !=null && !neighborBoard.equals(node.previous.board))) {
                newSearchNode = new SearchNode(neighborBoard, node.moves + 1, node);
                toExploreQueue.insert(newSearchNode);
            }
        }
    }
    
    private void updateSolutionBoards(SearchNode searchNode) {
        this.solutionBoards = new Stack<Board>();
        while(searchNode != null) {
            solutionBoards.push(searchNode.board);
            searchNode = searchNode.previous;
        }
    }
    
    // is the initial board solvable?
    public boolean isSolvable() {
        return hasSolution;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return movesToSolution;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solutionBoards;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
    
    private class SearchNode {
        private Board board;
        private int moves;
        private SearchNode previous;
        
        private SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }
    }
    
    // Compares two search nodes based on their distance to solution, and moves taken
    private class SearchNodeComparator implements Comparator<SearchNode> {

        @Override
        public int compare(SearchNode n1, SearchNode n2) {
            int n1Priority, n2Priority;
            if(HAMMING) {
                n1Priority = n1.board.hamming();
                n2Priority = n2.board.hamming();
            } else {
                n1Priority = n1.board.manhattan();
                n2Priority = n2.board.manhattan();
            }
            n1Priority += n1.moves;
            n2Priority += n2.moves;
            
            if(n1Priority < n2Priority) {
                return -1;
            } else if(n1Priority > n2Priority) {
                return 1;
            } else {
                return 0;
            }
        }
        
    }
}

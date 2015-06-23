package chapter4.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// A graph with only edges, no values
public class Graph {
	private int nodeCount = 0;
	private ArrayList<Set<Integer>> edges = null;
	private final int source = 0;
	
	public Graph(int nodeCount) {
		this.nodeCount = nodeCount;
		edges = new ArrayList<Set<Integer>>();
		
		for(int i = 0; i < nodeCount; i++) {
			edges.add(new HashSet<Integer>());
			
		}
	}
	
	public void addEdge(int from, int to) {
		if(from < 0 || from >= nodeCount ||
			to < 0 || to >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		edges.get(from).add(to);
	}

	public int getSource() {
		return source;
	}
	
	public Set<Integer> getEdges(int vertex) {
		if(vertex < 0 || vertex >= nodeCount) {
			
		}
		return edges.get(vertex);
	}
	
	public boolean dfs(int value) {
		return dfs(source, value);
	}
	
	// iterative DFS
	public boolean dfs(int source, int value) {
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> toVisit = new Stack<Integer>();
		
		toVisit.push(source);
		
		while(!toVisit.isEmpty()) {
			int visiting = toVisit.pop();
			visited.add(visiting);
			if(visiting == value) {
				return true;
			} else {
				for(Integer v : getEdges(visiting)) {
					if(!visited.contains(v)) {
						toVisit.push(v);
					}
				}
			}
		}
		return false;
	}
}

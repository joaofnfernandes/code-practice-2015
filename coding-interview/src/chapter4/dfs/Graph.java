package chapter4.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
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
	
	public boolean bfs(int value) {
		return bfs(source, value);
	}
	
	public boolean hasPath(int from, int to) {
		return dfs(from, to);
	}
	
	public Set<Integer> getNodesAtDepth(int depth) {
		HashSet<Integer> vertices = new HashSet<>();
		getNodesAtDepth(source, vertices, depth);
		return vertices;
	}
	
	//TODO: we aren't setting the source correctly
	public Graph revert() {
		Graph g = new Graph(this.nodeCount);
		
		for(Set<Integer> vertex : g.edges) {
			vertex.clear();
		}
		for(int i = 0; i < this.edges.size(); i++) {
			Set<Integer> vertexes = this.edges.get(i);
			for(Integer edge : vertexes) {
				g.edges.get(edge).add(i);
			}
		}
		
		return g;
	}
	
	//TODO: can be optimized if we run DFS at both graphs at same time
	public int findCommonAncestor(int v1, int v2) {
		Graph g = revert();
		Set<Integer> reachableFromV1 = g.dfsIterator(v1);
		Set<Integer> reacheableFromV2 = g.dfsIterator(v2);
		for(Integer v1Vertex : reachableFromV1) {
			if(reacheableFromV2.contains(v1Vertex)) {
				return v1Vertex;
			}
		}
		return -1;
	}
	
	// iterative DFS
	private boolean dfs(int source, int value) {
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

	private Set<Integer> dfsIterator(int source) {
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> toVisit = new Stack<Integer>();
		
		toVisit.push(source);
		
		while(!toVisit.isEmpty()) {
			int visiting = toVisit.pop();
			visited.add(visiting);
			for(Integer v : getEdges(visiting)) {
				if(!visited.contains(v)) {
					toVisit.push(v);
				}
			}
		}
		return visited;
	}

	private boolean bfs(int source, int value) {
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> toVisit = new ArrayDeque<Integer>();
		
		toVisit.add(source);
		
		while(!toVisit.isEmpty()) {
			int visiting = toVisit.remove();
			visited.add(visiting);
			if(visiting == value) {
				return true;
			} else {
				for(Integer v : getEdges(visiting)) {
					if(!visited.contains(v)) {
						toVisit.add(v);
					}
				}
			}
		}
		return false;
	}

	private void getNodesAtDepth(int node, HashSet<Integer> vertices, int depth) {
		if(depth == 0) {
			vertices.add(node);
			return;
		} else {
			for(Integer vertex : edges.get(node)) {
				getNodesAtDepth(vertex, vertices, depth - 1);
			}
		}
		
	}

}

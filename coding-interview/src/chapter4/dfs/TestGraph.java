package chapter4.dfs;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGraph {

	@Test
	public void TestDfsWithoutCycles() {
		Graph g = new Graph(4);
		g.addEdge(0, 1); g.addEdge(0, 2); 
		g.addEdge(2, 1);
		
		assertTrue(g.dfs(0)); assertTrue(g.dfs(1));
		assertTrue(g.dfs(2));
		assertTrue(!g.dfs(3));
	}
	
	@Test
	public void TestDfsWithCycles() {
		Graph g = new Graph(4);
		g.addEdge(0, 1); g.addEdge(0, 2); 
		g.addEdge(1, 0); g.addEdge(1, 2);
		g.addEdge(2, 1);
		
		assertTrue(g.dfs(0)); assertTrue(g.dfs(1));
		assertTrue(g.dfs(2)); assertTrue(!g.dfs(3));
	}
	
	@Test
	public void TestBfsWithoutCycles() {
		Graph g = new Graph(4);
		g.addEdge(0, 1); g.addEdge(0, 2); 
		g.addEdge(2, 1);
		
		assertTrue(g.bfs(0)); assertTrue(g.bfs(1));
		assertTrue(g.bfs(2));
		assertTrue(!g.bfs(3));
	}
	
	@Test
	public void TestBfsWithCycles() {
		Graph g = new Graph(4);
		g.addEdge(0, 1); g.addEdge(0, 2); 
		g.addEdge(1, 0); g.addEdge(1, 2);
		g.addEdge(2, 1);
		
		assertTrue(g.bfs(0)); assertTrue(g.bfs(1));
		assertTrue(g.bfs(2)); assertTrue(!g.bfs(3));
	}
}

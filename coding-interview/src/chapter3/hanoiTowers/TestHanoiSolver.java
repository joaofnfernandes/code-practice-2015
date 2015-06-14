package chapter3.hanoiTowers;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHanoiSolver {

	@Test
	public void TestSolve3Disks() {
		HanoiTower tower = new HanoiTower();
		HanoiTowerSolver solver = new HanoiTowerSolver(tower);
		solver.solve();

		String expected = "[] [] [210]";
		assertEquals(expected, tower.toString());
	}

	@Test
	public void TestSolve4Disks() {
		HanoiTower tower = new HanoiTower(4);
		HanoiTowerSolver solver = new HanoiTowerSolver(tower);
		solver.solve();

		String expected = "[] [] [3210]";
		assertEquals(expected, tower.toString());
	}

}

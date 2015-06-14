package chapter3.hanoiTowers;

public class Game {
	
	public static void main(String[] args) {
		HanoiTower tower = new HanoiTower();
		HanoiTowerSolver solver = new HanoiTowerSolver(tower);
		solver.solve();
	}

}

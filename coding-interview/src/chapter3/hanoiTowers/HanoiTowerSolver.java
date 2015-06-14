package chapter3.hanoiTowers;

public class HanoiTowerSolver {

	private HanoiTower tower;
	
	public HanoiTowerSolver(HanoiTower tower) {
		this.tower = tower;
	}
	
	public void solve() {
		moveTower(0, PegName.A, PegName.C, PegName.B);
	}
	
	private void moveTower(int index, PegName source, PegName dest, PegName spare) {

		// if on top move it, otherwise move the disks on top of it first
		if(tower.isTopDisk(source, index)) {
			tower.move(source, dest);
		} else {
			int towerToMoveIndex = index + 1;
			Disk towerToMove = tower.getDiskByIndex(source, towerToMoveIndex); 
					
			moveTower(towerToMoveIndex, source, spare, dest);
			tower.move(source, dest);
			
			towerToMoveIndex = tower.getDiskIndex(spare, towerToMove);
			moveTower(towerToMoveIndex, spare, dest, source);
		}
		
		
	}
		
}

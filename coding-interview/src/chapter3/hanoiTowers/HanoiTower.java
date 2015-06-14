package chapter3.hanoiTowers;

import java.util.EmptyStackException;

public class HanoiTower {
	
	private static final int DEFAULT_DISK_COUNT = 3;
	
	private Disk[] pegA = null;
	private Disk[] pegB = null;
	private Disk[] pegC = null;
	private int pegATop, pegBTop, pegCTop;
	

	public HanoiTower() {
		this(DEFAULT_DISK_COUNT);
	}
	
	public HanoiTower(int diskCount) {
		pegATop = pegBTop = pegCTop = -1;
		
		pegA = new Disk[diskCount];
		pegB = new Disk[diskCount];
		pegC = new Disk[diskCount];
		
		for(int i = diskCount - 1; i >= 0; i--) {
			pushA(new Disk(i));
		}
		
	}
	
	
	public void push(PegName peg, Disk disk) {
		switch (peg) {
		case A:
			pushA(disk);
			break;
		case B:
			pushB(disk);
			break;
		case C:
			pushC(disk);
			break;
		default:
			throw new IllegalStateException();
		}
	}

	public int getTopIndex(PegName peg) {
		switch (peg) {
		case A:
			return getIndexATop();
		case B:
			return getIndexBTop();
		case C:
			return getIndexCTop();
		default:
			throw new IllegalStateException();
		}
	}
	
	public boolean isTopDisk(PegName peg, int index) {
		switch (peg) {
		case A:
			return isATopDisk(index);
		case B:
			return isBTopDisk(index);
		case C:
			return isCTopDisk(index);
		default:
			throw new IllegalStateException();
		}
	}
	
	public void move(PegName source, PegName dest) {
		switch (source) {
		case A: {
			switch (dest) {
			case A: {
				return;
			}
			case B: {
				pushB(popA());
				return;
			}
			case C: {
				pushC(popA());
				return;
			}
			default:
				throw new IllegalStateException();
			}
		}
		
		case B: {
			switch (dest) {
			case A: {
				pushA(popB());
				return;
			}
			case B: {
				return;
			}
			case C: {
				pushC(popB());
				return;
			}
			default:
				throw new IllegalStateException();
			}
		}
		case C: {
			switch (dest) {
			case A: {
				pushA(popC());
				return;
			}
			case B: {
				pushB(popC());
				return;
			}
			case C: {
				return;
			}
			default:
				throw new IllegalStateException();
			}
		}
		default:
			throw new IllegalStateException();
		}
	}

	public Disk getDiskByIndex(PegName peg, int index) {
		switch (peg) {
		case A:
			return getDiskByIndexPegA(index);
		case B:
			return getDiskByIndexPegB(index);
		case C:
			return getDiskByIndexPegC(index);
		default:
			throw new IllegalStateException();
		}
	}
	
	public int getDiskIndex(PegName peg, Disk disk) {
		switch (peg) {
		case A:
			return getDiskIndexPegA(disk);
		case B:
			return getDiskIndexPegB(disk);
		case C:
			return getDiskIndexPegC(disk);
		default:
			throw new IllegalStateException();
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for(int i = 0; i <= pegATop; i++) {
			builder.append(pegA[i]);
		}
		builder.append("] [");
		for(int i = 0; i <= pegBTop; i++) {
			builder.append(pegB[i]);
		}
		builder.append("] [");
		for(int i = 0; i <= pegCTop; i++) {
			builder.append(pegC[i]);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	private void pushA(Disk disk) {
		pegA[++pegATop] = disk;
	}
	
	private void pushB(Disk disk) {
		pegB[++pegBTop] = disk;
	}
	
	private void pushC(Disk disk) {
		pegC[++pegCTop] = disk;
	}
	
	private Disk popA() {
		if(pegATop >= 0) {
			return pegA[pegATop--];
		} else {
			throw new EmptyStackException();
		}
	}
	
	private Disk popB() {
		if(pegBTop >= 0) {
			return pegB[pegBTop--];
		} else {
			throw new EmptyStackException();
		}
	}
	
	private Disk popC() {
		if(pegCTop >= 0) {
			return pegC[pegCTop--];
		} else {
			throw new EmptyStackException();
		}
	}
	
	private int getIndexATop() {
		return pegATop;
	}
	
	private int getIndexBTop() {
		return pegBTop;
	}
	
	private int getIndexCTop() {
		return pegCTop;
	}
	
	private boolean isATopDisk(int index) {
		if(pegATop < 0 || index < 0) {
			return false;
		} else {
			return index == pegATop;
		}
	}
	
	private boolean isBTopDisk(int index) {
		if(pegBTop < 0 || index < 0) {
			return false;
		} else {
			return index == pegBTop;
		}
	}
	
	private boolean isCTopDisk(int index) {
		if(pegCTop < 0 || index < 0) {
			return false;
		} else {
			return index == pegCTop;
		}
	}
	
	private int getDiskIndexPegA(Disk disk) {
		for(int i = 0; i <= pegATop; i++) {
			if(pegA[i].compareTo(disk) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	private int getDiskIndexPegB(Disk disk) {
		for(int i = 0; i <= pegBTop; i++) {
			if(pegB[i].compareTo(disk) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	private int getDiskIndexPegC(Disk disk) {
		for(int i = 0; i <= pegCTop; i++) {
			if(pegC[i].compareTo(disk) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	private Disk getDiskByIndexPegA(int index) {
		if(index > 0 && index <= pegATop) {
			return pegA[index];
		}
		return null;
	}
	
	private Disk getDiskByIndexPegB(int index) {
		if(index > 0 && index <= pegBTop) {
			return pegB[index];
		}
		return null;
	}
	
	private Disk getDiskByIndexPegC(int index) {
		if(index > 0 && index <= pegCTop) {
			return pegC[index];
		}
		return null;
	}
}

package chapter2.cycleDetection;

import chapter2.linkedList.*;
import org.junit.Test;
import static chapter2.cycleDetection.CycleDetection.*;

public class TestCycleDetection {

	@Test
	public void TestIsCircular() {
		int size = 100;
		Node<Integer>[] list = createList(size);
		
		// close on first
		list[size - 1].next = list[0];
		isCircular(list[0]);
		
		//close on middle
		list[size - 1].next = list[50];
		isCircular(list[0]);
		
		// close on self
		list[size - 1].next = list[size - 1];
		isCircular(list[0]);
		
	}
	
	@SuppressWarnings("unchecked")
	private Node<Integer>[] createList(int size) {
		Node<Integer>[] list = new Node[size];
		for(int i = 0; i < list.length; i++) {
			list[i] = new Node<Integer>(i);
		}
		for(int i = 0; i < list.length - 1; i++) {
			list[i].next = list[i + 1];
		}
		return list;
	}

}

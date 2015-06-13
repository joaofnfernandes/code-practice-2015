package chapter2.cycleDetection;
import chapter2.linkedList.*;

public class CycleDetection {

	//Floyd cycle-finding algorithm
	public static<T> boolean isCircular(Node<T> n) {
		Node<T> tortoise = n;
		Node<T> hare = n;
		
		do {
			if(hare.next == null || hare.next.next == null) return false;
			hare = hare.next.next;
			tortoise = tortoise.next;	
		}
		while(tortoise != hare);
		return true;
	}

}

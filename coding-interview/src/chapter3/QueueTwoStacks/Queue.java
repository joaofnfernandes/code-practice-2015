package chapter3.QueueTwoStacks;

import java.util.Stack;

public class Queue<E> {
	// temporarily stores elements in reversed order
	private Stack<E> s1 = null;
	// elements are in correct order to be returned
	private Stack<E> s2 = null;
	
	public Queue() {
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
	}
	
	public E pop() {
		if(s2.isEmpty() && !s1.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		if(s2.isEmpty()) {
			return null;
		} else {
			return s2.pop();
		}
	}
	
	public void push(E element) {
		s1.push(element);
	}
}

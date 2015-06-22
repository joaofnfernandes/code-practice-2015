package chapter3.stackSorting;

import java.util.Stack;

public class SortStack<E extends Comparable<E>> {
	
	public Stack<E> sort(Stack<E> s) {
		Stack<E> tmp = new Stack<E>();
		Stack<E> result = new Stack<E>();
		E elem = null;
		while(!s.empty()) {
			elem = s.pop();
			while(!result.isEmpty() && elem.compareTo(result.peek()) > 0) {
				tmp.push(result.pop());
			}
			result.push(elem);
			while(!tmp.empty()) {
				result.push(tmp.pop());
			}
		}
		return result;
	}

}

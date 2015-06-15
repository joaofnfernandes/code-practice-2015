package chapter3.setOfStacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<E> {
	private static final int DEFAULT_MAX_STACK_SIZE = 5;
	
	private int maxStackSize = DEFAULT_MAX_STACK_SIZE;
	private ArrayList<Stack<E>> stacks = null;
	int currStackIndex = -1;
	
	public SetOfStacks(int maxStackSize) {
		this.maxStackSize = maxStackSize;
		stacks = new ArrayList<Stack<E>>();
		stacks.add(new Stack<E>());
		currStackIndex++;
	}
	
	public SetOfStacks() {
		this(DEFAULT_MAX_STACK_SIZE);
	}
	
	public void push(E element) {
		Stack<E> currStack = stacks.get(currStackIndex);
		if(currStack.size() == maxStackSize) {
			stacks.add(new Stack<E>());
			currStackIndex++;
		}
		
		currStack.push(element);
	}
	
	public E pop() {
		Stack<E> currStack = stacks.get(currStackIndex);
		E value = currStack.pop();
		if(currStack.size() == 0) {
			currStackIndex = currStackIndex - 1 <= 0 ? 0 : currStackIndex - 1;
		}
		return value;
	}
	
	public boolean isEmpty() {
		return currStackIndex == 0 && stacks.get(0).size() == 0;
	}

}

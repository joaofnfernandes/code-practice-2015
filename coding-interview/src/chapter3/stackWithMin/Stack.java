package chapter3.stackWithMin;

public class Stack<T extends Comparable<T>> {
	private StackNode stackPtr = null;
	private MinNode minPtr = null;
	
	public T pop() {
		T value = null;
		if(stackPtr != null) {
			value = stackPtr.value;
			// delete node from minStack
			deleteFromMin(stackPtr);
			deleteFromStack(stackPtr);
		}
		return value;
	}
	
	public T min() {
		if(minPtr != null) {
			return minPtr.stackNodePtr.value;
		}
		return null;
	}
	
	public void push(T value) {
		// update stack
		StackNode stackNodePtr = new StackNode(value,stackPtr);
		stackPtr = stackNodePtr;
		
		
		// update min stack
		MinNode newMinNode = new MinNode(stackNodePtr);
		
		if(minPtr != null) {
			if(minPtr.stackNodePtr.value.compareTo(value) >= 0) {
				newMinNode.next = minPtr;
				minPtr = newMinNode;
			} else {
				MinNode curr = minPtr;
				while(curr.next != null && curr.next.stackNodePtr.value.compareTo(value) < 0) {
					curr = curr.next;
				}
				newMinNode.next = curr.next;
				curr.next = newMinNode;
			}
		} else {
			minPtr = newMinNode;
		}
		
	}
	
	private void deleteFromMin(StackNode nodeToDelete) {
		if(minPtr == null || nodeToDelete == null) {
			return;
		}
		MinNode curr = minPtr;
		if(curr.stackNodePtr == nodeToDelete) {
			minPtr = minPtr.next;
		} else {
			while(curr.next != null && curr.next.stackNodePtr != nodeToDelete) {
				curr = curr.next;
			}
			if(curr.next.stackNodePtr == nodeToDelete) {
				curr.next = curr.next.next;
			}
		}
	}
	
	private void deleteFromStack(StackNode nodeToDelete) {
		if(stackPtr == null || nodeToDelete == null) {
			return;
		}
		StackNode curr = stackPtr;
		if(curr == nodeToDelete) {
			stackPtr = stackPtr.next;
		} else {
			while(curr.next != null && curr.next != nodeToDelete ) {
				curr = curr.next;
			}
			if(curr.next == nodeToDelete) {
				curr.next = curr.next.next;
			}
		}
	}
	
	
	private class StackNode {
		private T value = null;
		private StackNode next = null;
		
		protected StackNode(T value, StackNode stackNodePtr) {
			this.value = value;
			this.next = stackNodePtr;
		}
	
		
	}
	
	private class MinNode {
		private MinNode next = null;
		private StackNode stackNodePtr = null;
		
		private MinNode(StackNode stackNodePtr ) {
			this(stackNodePtr, null);
		}
		
		private MinNode(StackNode stackNodePtr, MinNode next) {
			this.stackNodePtr = stackNodePtr;
			this.next = next;
		}
		
	}

}

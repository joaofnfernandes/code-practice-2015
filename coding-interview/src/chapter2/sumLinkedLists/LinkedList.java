package chapter2.sumLinkedLists;

import java.util.ArrayList;

// An immutable linked list
public class LinkedList {

	private final ArrayList<Integer> list = new ArrayList<>();
	
	public LinkedList(){}
	
	public LinkedList(Integer[] arr) {
		for(Integer i : arr) {
			list.add(i);
		}
	}
	
 	public void add(Integer value) throws InvalidValueException {
		if(value < 0 || value > 9) {
			throw new InvalidValueException();
		}
		list.add(value);
	}
	
	public void add(int index, Integer value) {
		list.add(index, value);
	}
	
	// Returns the value or null
	public Integer pop() {
		Integer value = null;
		try {
			value = list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			value = null;
		}
		return value;
		
	}
	
	public static LinkedList sum(LinkedList l1, LinkedList l2) throws InvalidValueException {
		final LinkedList sum = new LinkedList();
		l1 = l1.reverse();
		l2 = l2.reverse();
		
		return recursiveSum(l1, l2, sum, 0).reverse();		
	}

	public Integer[] toArray() {
		Integer[] arr = new Integer[list.size()];
		arr = list.toArray(arr);
		return arr;
	}
	
	private LinkedList reverse() throws InvalidValueException {
		final LinkedList reversed = new LinkedList();
		for(int i = list.size() - 1; i >= 0; i--) {
			reversed.add(list.get(i));
		}
		return reversed;
	}
	
	private static LinkedList recursiveSum(LinkedList l1, LinkedList l2, LinkedList sum, int carry) throws InvalidValueException {
		if(l1 == null && l2 == null) {
			return sum;
		}
		Integer value1 = l1.pop();
		Integer value2 = l2.pop();
		if(value1 == null && value2 == null) {
			if(carry != 0) {
				sum.add(carry);
			}
			return sum;
		}
		
		int total = carry;
		
		if(value1 == null) {
			total += value2;
		} else if(value2 == null) {
			total += value1;
		} else {
			total += value1;
			total += value2;
		}
		if(total >= 10) {
			total -= 10;
			carry = 1;
		} else {
			carry = 0;
		}
		sum.add(total);
		return recursiveSum(l1, l2, sum, carry);
	}
	
	public class InvalidValueException extends Exception {
		private static final long serialVersionUID = 1L;
		
	}

}

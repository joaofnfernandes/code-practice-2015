package chapter4.heap;

import java.util.ArrayList;

// A max-heap
public class Heap<T extends Comparable<T>> {
	private static final int FIRST = 1;
	private static final int INITIAL_CAPACITY = 10;
	
	private ArrayList<T> arr = null;
	private int last = FIRST;
	
	
	public Heap(T[] values) {
		arr = new ArrayList<T>(INITIAL_CAPACITY);
		
		//add a dummy element at [0] so that we have 1-based indexing
		arr.add(null);
		
		for(T value : values) {
			insert(value);
		}
	}
	
	public T max() {
		if(last == FIRST) {
			throw new EmptyHeapException();
		}
		return arr.get(FIRST);
	}

	public boolean contains(T value) {
		return contains(FIRST, value);
	}
	
	public void insert(T value) {
		arr.add(last, value);
		int curr = last;
		int parent = last / 2;
		while(parent >= 1) {
			if(arr.get(curr).compareTo(arr.get(parent)) > 0) {
				swap(arr, curr, parent);
			} else {
				break;
			}
			curr = parent;
			parent = parent / 2;
		}
		last++;
	}

	public T pop() {
		T value = arr.get(--last);
		for(int i = FIRST + 1; i < last; i = i*2) {
			if(arr.get(i / 2).compareTo(arr.get(i)) < 0) {
				swap(arr, i / 2, i);
			} else if(arr.get(i / 2).compareTo(arr.get(i + 1)) < 0) {
				swap(arr, i / 2, i + 1);
			} else {
				break;
			}
		}
		return value;
	}

	private void swap(ArrayList<T> arr, int i, int j) {
		T aux = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, aux);
	}
	
	private boolean contains(int i, T value) {
		if(i >= last) {
			return false;
		} else if(arr.get(i).compareTo(value) == 0) {
			return true;
		} else {
			return contains(i * 2, value) || contains(i * 2 + 1, value);
		}
	}

	
}

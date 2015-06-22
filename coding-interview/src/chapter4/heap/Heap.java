package chapter4.heap;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {
	private static final int FIRST = 1;
	
	private T[] arr = null;
	private int last = FIRST;
	
	
	@SuppressWarnings("unchecked")
	public Heap(T[] values) {
		this.arr = (T[])Array.newInstance(values[0].getClass(), values.length + 1);
		for(T value : values) {
			insert(value);
		}
	}
	
	public void insert(T value) {
		arr[last] = value;
		int curr = last;
		int parent = last / 2;
		while(parent >= 1) {
			if(arr[curr].compareTo(arr[parent]) > 0) {
				swap(arr, curr, parent);
			} else {
				break;
			}
			curr = parent;
			parent = parent / 2;
		}
		last++;
	}
	
	public T max() {
		if(last == FIRST) {
			throw new EmptyHeapException();
		}
		return arr[FIRST];
	}

	public boolean contains(T value) {
		return contains(FIRST, value);
	}
	
	private void swap(T[] arr, int i, int j) {
		T aux = arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}
	
	private boolean contains(int i, T value) {
		if(i >= last) {
			return false;
		} else if(arr[i].compareTo(value) == 0) {
			return true;
		} else {
			return contains(i * 2, value) || contains(i * 2 + 1, value);
		}
	}

	
}

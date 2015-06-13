package chapter3.stacks;


public class Deque<E> {

	private static final int INITIAL_CAPACITY = 10;
	private static final int SIZE_INCREMENTS = 2;
	
	private int capacity = INITIAL_CAPACITY;
	private int size, first, last = 0;
	@SuppressWarnings("unchecked")
	private E[] arr = (E[]) new Object[INITIAL_CAPACITY];
	
	
	public boolean empty() {
		return size == 0;
	}
	
	public E peek(int index) {
		if(last <= first) {
			if(index < last || index >=first)
				throw new IndexOutOfBoundsException();
		} else {
			if(index < 0 || index > capacity || (index >= first && index > last)) {
				throw new IndexOutOfBoundsException();
			}
		}
		return arr[index];
	}
	
	public void push(E element) {
		if(size == capacity) {
			//increase size
		}
		arr[first++] = element;
		first = first == size ? 0 : first;
		size++;
	}
	
	public E pop() {
		if(size == 0) {
			return null;
		}
		first = --first == -1 ? size - 1 : first;
		return arr[first];
	}

}

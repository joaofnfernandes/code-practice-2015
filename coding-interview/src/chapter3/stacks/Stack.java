package chapter3.stacks;

public class Stack<E> {

	private static final int INITIAL_CAPACITY = 10;
	private static final int SIZE_INCREMENTS = 2;
	
	private int capacity = INITIAL_CAPACITY;
	private int first;
	@SuppressWarnings("unchecked")
	private E[] arr = (E[]) new Object[INITIAL_CAPACITY];
	
	
	public boolean empty() {
		return first == 0;
	}
	
	public E peek(int index) {
		if(index < 0 || index >= first) {
			
		}
		return arr[index];
	}
	
	public void push(E element) {
		if(first == capacity) {
			increaseCapacity();
		}
		arr[first++] = element;
	}
	
	public E pop() {
		if(first == 0) {
			return null;
		}
		if(first < capacity / (2 * SIZE_INCREMENTS)) {
			decreaseCapacity();
		}
		return arr[--first];
	}
	
	private void increaseCapacity() {
		int newCapacity = capacity * SIZE_INCREMENTS;
		@SuppressWarnings("unchecked")
		E[] aux = (E[]) new Object[newCapacity];
		for(int i = 0; i < first; i++) {
			aux[i] = arr[i];
		}
		capacity = newCapacity;
		arr = aux;
	}
	
	private void decreaseCapacity() {
		int newCapacity = capacity / SIZE_INCREMENTS;
		@SuppressWarnings("unchecked")
		E[] aux = (E[]) new Object[newCapacity];
		for(int i = 0; i < first; i++) {
			aux[i] = arr[i];
		}
		capacity = newCapacity;
		arr = aux;
	}

}

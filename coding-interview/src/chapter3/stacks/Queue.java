package chapter3.stacks;

//TODO: do we really need the capacity var?
public class Queue<E> {

	private static final int INITIAL_CAPACITY = 10;
	private static final int SIZE_INCREMENTS = 2;
	
	private int capacity = INITIAL_CAPACITY;
	private int size, last, first = 0;
	@SuppressWarnings("unchecked")
	private E[] arr = (E[]) new Object[INITIAL_CAPACITY];
	
	
	public boolean empty() {
		return size == 0;
	}
	
	public E peek(int index) {
		if(first <= last) {
			if(index < first || index >= last)
				throw new IndexOutOfBoundsException();
		} else {
			if(index < 0 || index >= capacity || (index >= last && index < first)) {
				throw new IndexOutOfBoundsException();
			}
		}
		return arr[index];
	}
	
	public void push(E element) {
		if(size == capacity) {
			increaseCapacity();
		}
		arr[last++] = element;
		last = last == capacity ? 0 : last;
		size++;
	}
	
	public E pop() {
		if(size == 0) {
			return null;
		}
		E value = arr[first++];
		first = first == capacity ? 0 : first;
		size--;
		return value;
	}

	private void increaseCapacity() {
		int newCapacity = capacity * SIZE_INCREMENTS;
		@SuppressWarnings("unchecked")
		E[] aux = (E[]) new Object[newCapacity];
		for(int i = 0; i < capacity; i++) {
			first = first == capacity ? 0 : first;
			aux[i] = arr[first++];
		}
		first = 0;
		last = capacity;
		capacity = newCapacity;
		arr = aux;
	}
}

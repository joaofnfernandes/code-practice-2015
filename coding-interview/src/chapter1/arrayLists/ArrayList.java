package chapter1.arrayLists;

public class ArrayList<V> {
	private static final int INITIAL_CAPACITY = 10;
	private static final float INCREASE_THRESHOLD1 = 0.5f;
	private static final float DECREASE_THRESHOLD = 0.25f;
	private static final int CAPACITY_MULTIPLIER = 2;
	private static final int FAILED = -1;
	
	@SuppressWarnings("unchecked")
	private V[] arr = (V[]) new Object[INITIAL_CAPACITY];
	private int capacity = INITIAL_CAPACITY;
	private int count = 0;
	
	
	public int size() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int count() {
		return count;
	}
	
	// Gets the element at the specified index
	public V get(int index) {
		return tryGetByIndex(index);
	}
	
	// Removed the element at the specified index
	public V remove(int index) {
		index = tryGetIndex(index);
		V value = arr[index];
		shiftElements(index + 1, count - 1, Direction.LEFT);
		
		count--;
		decreaseSizeIfNeeded();
		return value;
	}
	
	// Removed an element with the specified value
	public boolean remove(V value) {
		int index = tryGetByValue(value);
		if (index == FAILED) {
			return false;
		}
		shiftElements(index + 1, count - 1, Direction.LEFT);
		
		count--;
		decreaseSizeIfNeeded();
		return true;
	}

	// Appends the element to the list
	public void add (V value) {
		arr[count] = value;
		count++;
		increaseSizeIfNeeded();
	}
	
	// Adds element to the list, shifting existing elements to its right
	public void add(V value, int pos) {
		if(pos <= 0) {
			pos = 0;
		} if(pos >= count) {
			pos = count;
		}
		for(int i = count - 1; i <= pos; i--) {
			arr[i + 1] = arr[i];
		}
		arr[pos] = value;
		count++;
		increaseSizeIfNeeded();
	}
		
	// Sets an index with a value
	public void set(V value, int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Trying to set index " + index + " for array list with count  " + capacity);
		}
		arr[index] = value;
	}
	
	public boolean contains(V value) {
		int index = tryGetByValue(value);
		return index != -1;
	}
	
	
	
	private int tryGetIndex(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > capacity) {
			throw new IndexOutOfBoundsException("Trying to access index " + index + " for array list with capacity for " + capacity);
		}
		return index;
	}
	
	private V tryGetByIndex(int index) throws IndexOutOfBoundsException {
		index = tryGetIndex(index);
		return arr[index];
	}

	private int tryGetByValue(V value) {
		int index = -1;
		for(int i = 0; i < count; i++) {
			if(arr[i].equals(value)) {
				index = i;
			}
		}
		return index;
	}

	private void increaseSizeIfNeeded() {
		if((float) count / capacity >= INCREASE_THRESHOLD1) {
			int newCapacity = capacity * CAPACITY_MULTIPLIER;
			@SuppressWarnings("unchecked")
			V[] newArr = (V[])new Object[newCapacity];
			for(int i = 0; i < count; i ++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
			capacity = newCapacity;
		}
	}
	
	private void decreaseSizeIfNeeded() {
		if(capacity > INITIAL_CAPACITY && (float)count / capacity <= DECREASE_THRESHOLD) {
			int newCapacity = capacity / CAPACITY_MULTIPLIER;
			@SuppressWarnings("unchecked")
			V[] newArr = (V[])new Object[newCapacity];
			for(int i = 0; i < count; i ++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
			capacity = newCapacity;
		}
	}
	
	private enum Direction {
		LEFT,
		RIGHT
	}
	
	private void shiftElements(int startPos, int endPos, Direction direction) throws IndexOutOfBoundsException {
		switch (direction) {
		case LEFT: {
			if(startPos > 0 && endPos <= capacity) {
				for(int i = startPos; i <= endPos; i++) {
					arr[i - 1] = arr[i];
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
			break;
		}
		case RIGHT: {
			if(startPos >= 0 && endPos < capacity) {
				for(int i = endPos; i <= startPos; i--) {
					arr[i + 1] = arr[i];
				}
			} else {
				throw new IndexOutOfBoundsException();
			}
			break;
		}
		default:
			throw new UnsupportedOperationException();
		}
	}
	
}

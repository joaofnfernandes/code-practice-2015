package OpenAddressing;

//TODO: implement resizing
public class HashTable<K,V> {
	private static final int FAILED = -1;
	private static final int SIZE = 10;
	private int elementCount = 0;
	
	@SuppressWarnings("unchecked")
	private KeyValuePair<K, V>[] arr = (KeyValuePair<K, V>[]) new KeyValuePair[SIZE];
	
	public void put(K key, V value) {
		if (elementCount == SIZE) {
			return;
		} else {
			// while try put fails, and not wrapped around: try put
			int index = hash(key);
			
			while(tryPut(key, value, index) == FAILED) {
				index = index + 1 == SIZE ? 0 : index + 1; 
			}
			elementCount++;
		}
	}
	
	private int tryPut(K key, V value, int index) {
		if (arr[index] == null) {
			arr[index] = new KeyValuePair<K,V>(key, value);
			return index;
		}
		return FAILED;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		return index == FAILED ? null : arr[index].Value;
	}
	
	public V remove(K key) {
		int index = getIndex(key);
		if (index != FAILED) {
			V value = arr[index].Value;
			arr[index] = null;
			elementCount--;
			return value;
		} else {
			return null;
		}	
	}	
	
	public int size() {
		return elementCount;
	}
	
	private int hash(K key) {
		return key.hashCode() % SIZE;
	}

	private int getIndex(K key) {
		int originalIndex = hash(key);
		int shiftedIndex = originalIndex;
		int shiftedPositions = 0;
		
		// shift until wrapping around. It's possible that a key that collided was removed
		while(shiftedPositions < SIZE) {
			if (arr[shiftedIndex] != null && arr[shiftedIndex].Key.equals(key)) {
				break;
			} 
			shiftedIndex = shiftedIndex + 1 == SIZE ? 0 : shiftedIndex + 1;
			shiftedPositions++;	
		}
		// It either wrapped or is at correct index
		return shiftedPositions == SIZE ? FAILED : shiftedIndex;
	}
}

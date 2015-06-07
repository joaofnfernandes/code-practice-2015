package chapter1.separateChaining;

// TODO: Implement dynamic resizing when table is 0.75 full
public final class HashTable<K, V> {
	private static final int SIZE = 10;
	private int elementsCount = 0;
	
	@SuppressWarnings("unchecked")
	private final KeyValuePair<K, V>[] arr =  (KeyValuePair<K, V>[]) new KeyValuePair[SIZE];
	
	
	public HashTable() {
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = null;
		}
	}
	
	// Always inserts at the beginning of linked list
	public void put(K key, V value) {
		int index = hash(key);
		
		KeyValuePair<K, V> keyValue = new KeyValuePair<K,V>(key, value);
		keyValue.Next = arr[index];
		
		arr[index] = keyValue;
		elementsCount++;
	}
	
	// Returns a value for a key, or null
	public V get(K key) {
		int index = hash(key);
		KeyValuePair<K, V> pair = arr[index];
		
		while(pair != null) {
			if (pair.Key.equals(key)) {
				return pair.Value;
			}
		}
		return null;
	}

	public V remove(K key) {
		int index = hash(key);
		KeyValuePair<K, V> currPair = arr[index];
		KeyValuePair<K, V> previousPair = null;
		
		while(currPair != null) {
			if(currPair.Key.equals(key)) {
				if(previousPair != null) {
					previousPair.Next = currPair.Next;
				} else {
					arr[index] = currPair.Next;
				}
				break;
			}
			// iterate on linked list
			previousPair = currPair;
			currPair = currPair.Next;
		}
		
		return currPair == null ? null : currPair.Value;
	}
	
	public int size( ) {
		return elementsCount;
	}
	
	private int hash(K key) {
		return key.hashCode() % SIZE;
	}

}

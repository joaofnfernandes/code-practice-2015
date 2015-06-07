package chapter1.openAddressing;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestHashTable {
	
	@Test
	public void getNonExisting() {
		HashTable<Integer, String> hashTable = new HashTable<>();
		String result = hashTable.get(1);
		assertEquals("Value exists but shouldn't", null, result);
	}
	
	@Test
	public void putAndRetrieve () {
		HashTable<Integer, String> hashTable = new HashTable<>();
		hashTable.put(1, "A");
		String result = hashTable.get(1);
		assertEquals("A was stored but not found", "A", result);
	}
	
	@Test
	public void putWithCollisions() {
		HashTable<Integer, String> hashTable = new HashTable<>();
		hashTable.put(1, "A");
		hashTable.put(1, "A");
		String result = hashTable.get(1);
		
		assertEquals("A was stored but not found", "A", result);
		assertEquals("Hash table size should be 2", 2, hashTable.size());
	}
	
	@Test
	public void putDelete() {
		HashTable<Integer, String> hashTable = new HashTable<>();
		hashTable.put(1, "A");
		hashTable.remove(1);
		String result = hashTable.get(1);
		assertEquals("A is being found, but shouldn't", null, result);
	}
	
	@Test
	public void deleteWithoutPuttign() {
		HashTable<Integer, String> hashTable = new HashTable<>();
		String result = hashTable.remove(1);
		assertEquals("Can't delete element that's not there", null, result);
	}
	
	@Test
	public void putDeleteWithCollisions() {
		HashTable<Integer, String> hashTable = new HashTable<>();
		hashTable.put(1, "A"); hashTable.put(1, "A"); hashTable.put(1, "A");
		hashTable.remove(1);
		String result = hashTable.get(1);
		
		assertEquals("A is should be in table but isn't", "A", result);
		assertEquals("Hash not deleting elements with collisions correctly", 2, hashTable.size());
	}
	
	@Test
	public void testSize(){
		HashTable<Integer, Integer> hashTable = getHashWithElements(5);
		hashTable.put(1, 1);
		hashTable.remove(1);
		assertEquals("Hash size should be 5", 5, hashTable.size());
	}
	
	@Test
	public void insertMoreThanSize() {
		HashTable<Integer, Integer> hashTable = getHashWithElements(100);
		assertEquals("Hash can't store more than 10 elements", 10, hashTable.size());
	}
	
	private HashTable<Integer, Integer> getHashWithElements(int count) {
		HashTable<Integer, Integer> hashTable = new HashTable<>();
		
		for(int i = 0; i < count; i++) {
			hashTable.put(((Double)Math.random()).intValue(), ((Double)Math.random()).intValue()); 
		}
		return hashTable;
	}
	

}

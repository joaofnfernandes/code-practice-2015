package chapter1.separateChaining;

public class KeyValuePair<K,V> {
	public K Key;
	public V Value;
	public KeyValuePair<K, V> Next = null;
	
	public KeyValuePair(K Key, V Value) {
		this.Key = Key;
		this.Value = Value;
	}

}

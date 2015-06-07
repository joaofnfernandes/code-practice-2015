package stringBuilder;

import java.util.Arrays;

public class StringBuilder {
	private final static int DEFAULT_CAPACITY = 16;
	private final static int SIZE_MULTIPLIER = 2;
	
	private char[] chars = null;
	private int count = 0;
	private int capacity;
	
	
	public StringBuilder() {
		capacity = DEFAULT_CAPACITY;
		chars = new char[capacity];
	}
	
	public StringBuilder(int capacity) {
		this.capacity = capacity;
		chars = new char[capacity];
	}
	
	public StringBuilder(String str) {
		this();
		append(str);
	}
	
	
	public StringBuilder append(String s){
		if(s.length() > capacity - count) {
			resize();
		}
		for(int i = 0; i < s.length(); i++) {
			chars[count++] = s.charAt(i);
		}
		return this;
	}
	
	private void resize() {
		int newCapacity = capacity * SIZE_MULTIPLIER;
		char[] newCharArr = new char[newCapacity];
		for(int i = 0; i < count; i++) {
			newCharArr[i] = chars[i]; 
		}
		capacity = newCapacity;
		chars = newCharArr;
	}
	
	public StringBuilder append(Object o){
		return append(o.toString());
	}
	
	public char charAt(int index) {
		if(index < 0 || index > count) {
			throw new StringIndexOutOfBoundsException();
		}
		return chars[index];
	}
	
	
	public StringBuilder deleteCharAt(int index) {
		return delete(index, index + 1);
		
	}
	
	public StringBuilder delete(int start, int end) {
		if(start < 0 || start > count || end < 0 || end > count) {
			throw new StringIndexOutOfBoundsException();
		}
		//shift elements left, no need to overwrite remaining values
		int i = 0, j = 0;
		for(i = 0, j = end; j < count; i++, j++) {
			chars[i] = chars[j];
		}
		count -= end - start;
		return this;
	}
	
	public int length() {
		return count;
	}
	
	public StringBuilder reverse() {
		for(int i = 0; i < count / 2; i++) {
			swapChars(i, count - 1 - i);
		}
		return this;
	}
	
	private void swapChars(int a, int b) {
		char aux = chars[a];
		chars[a] = chars[b];
		chars[b] = aux;
	}
	
	public String substring(int start) {
		return substring(start, count);
	}
	
	public String substring(int start, int end){
		char[] subArray = Arrays.copyOfRange(chars, start, end);
		return new String(subArray);
		
	}
	
	public String toString() {
		return new String(Arrays.copyOfRange(chars, 0, count));
	}
	
	
}

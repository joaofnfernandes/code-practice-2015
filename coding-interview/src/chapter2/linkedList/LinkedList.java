package chapter2.linkedList;

import java.util.ArrayList;

public class LinkedList<T> {
	private int size = 0;
	private Node<T> first, last = null;
	
		
	public void add(T value, int index){
		first = addRecursive(value, first, index);
		if(last == null) {
			last = first;
		}
		size++;
	}
	
	private Node<T> addRecursive(T value, Node<T> curr, int index) {
		if(curr == null) {
			Node<T> newNode = new Node<T>(value);
			last = newNode;
			return newNode;
		} else if(index == 0) {
			Node<T> newNode = new Node<T>(value);
			newNode.next = curr;
			return newNode;
		} else {
			curr.next = addRecursive(value, curr.next, index - 1);
			return curr;
		}
	}
	
	public void addFirst(T value){
		add(value, 0);
	}
	
	public void addLast(T value) {
		add(value, size);
	}
	
	public boolean contains(T value){
		return indexOf(value) != -1;
	}
	
	public int indexOf(T value){
		if(first == null) {
			return -1;
		}
		Node<T> curr = first;
		int index = 0;
		while(curr != null) {
			if(curr.value.equals(value)) {
				return index;
			}
			curr = curr.next;
			index++;
		}
		return -1;
	}
	
	public T getFirst(){
		return first.value;
	}
	
	public T getLast(){
		return last.value;
	}
	
	public int size(){
		return size;
	}
	
	public T removeFirst() {
		if(first == null) {
			return null;
		}
		T value = first.value;
		first = first.next;
		size--;
		
		return value;
	}
	
	public T removeFirstOccurence(T value){
		int index = indexOf(value);
		if(index < 0) {
			return null;
		}
		return remove(index);
	}
	
	public T remove(int index) {
		index = index <= 0 ? 0 : index;
		index = index >= size - 1 ? size - 1 : index;
		
		if(first == null) {
			return null;
		}
		
		Node<T> curr = null;
		if(index == 0) {
			curr = first;
			first = first.next;
		} else {
			curr = first;
			while(index - 1 != 0) {
				curr = curr.next;
				index--;
			}
			Node<T> tmp = curr.next;
			curr.next = curr.next.next;
			if(curr.next == null) {
				last = curr;
			}
			curr = tmp;
		}
		size--;
		if(size == 1) {
			last = first;
		}
		return curr.value;
	}

	public void removeDuplicates() {
		if(first == null) {
			return;
		} else {
			Node<T> curr = first;
			while(curr != null) {
				ArrayList<Integer> occurrences = getOccurrences(curr.value);
				// remove first occurrence, since its the current value
				occurrences.remove(0);
				if(occurrences.size() > 0) {
					int deleted = 0;
					for(Integer i : occurrences) {
						remove(i - deleted);
						deleted++;
					}
				}
				curr = curr.next;
			}
		}
	}

	private ArrayList<Integer> getOccurrences(T value) {
		ArrayList<Integer> occurences = null;
		if(first != null) {
			occurences = new ArrayList<Integer>();
			Node<T> curr = first;
			int i = 0;
			while(curr != null) {
				if(curr.value.equals(value)) {
					occurences.add(i);
				}
				curr = curr.next;
				i++;
			}
		}
		return occurences;
	}
	
	

}

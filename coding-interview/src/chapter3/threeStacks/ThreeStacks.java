package chapter3.threeStacks;

//TODO we really need to keep sizes for each stack, in case of overlaps
public class ThreeStacks<E> {
	
	private static final int INITIAL_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	private final E[] arr = (E[]) new Object[INITIAL_CAPACITY];
	private int stack1 = 0; 
	private int stack2 = arr.length - 1;
	private int stack3 = arr.length / 2;
	private int stack1Size, stack2Size, stack3Size = 0;
	private boolean addElementToLeft = false;
	
	
	public void push(StackNumber s, E element) {
		switch (s) {
		case ONE:
			pushOnStack1(element);
			break;
		case TWO:
			pushOnStack2(element);
			break;
		case THREE:
			pushOnStack3(element);
			break;
		}
	}
	
	public E pop(StackNumber s) {
		switch (s) {
		case ONE:
			return popStack1();
		case TWO:
			return popStack2();
		case THREE:
			return popStack3();
		default:
			return null;
		}
	}
	
	
	private int totalSize() {
		return stack1Size + stack2Size + stack3Size;
	}
	
	private void pushOnStack1(E element){
		if(arr[stack1] == null) {
			stack1Size++;
			arr[stack1++] = element;
		}
	}

	private void pushOnStack2(E element){
		if(arr[stack2] == null) {
			stack2Size++;
			arr[stack2--] = element;
		}
	}
	
	
	private void pushOnStack3(E element){
		if(arr[stack3] == null) {
			arr[stack3] = element;
			stack3Size++;
			addElementToLeft = !addElementToLeft;
			if(addElementToLeft) {
				stack3 = stack3 - stack3Size;
			} else {
				stack3 = stack3 + stack3Size;
			}
		}
	}

	private E popStack1() {
		if(stack1Size > 0) {
			E value = arr[--stack1]; 
			arr[stack1] = null;
			return value;
		}
		return null;
	}
	
	private E popStack2() {
		if(stack2Size > 0) {
			E value = arr[++stack2];
			arr[stack2] = null;
			return value;
		}
		return null;
	}
	
	private E popStack3() {
		if(stack3Size > 0) {
			if(addElementToLeft) {
				stack3 = stack3 + stack3Size;
			} else {
				stack3 = stack3 - stack3Size;
			}
			E value = arr[stack3];
			arr[stack3] = null;
			stack3Size--;
			addElementToLeft = !addElementToLeft;
			return value;
		}
		return null;
	}
}

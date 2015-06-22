package chapter4.binaryTree;

public class BinaryTree<T extends Comparable<T>> {
	private Node<T> root = null;
	
	public void insert(T value) {
		root = insert(root, value);
	}
	
	public boolean contains(T value) {
		return contains(root, value);
	}
		
	public int size() {
		return size(root);
	}
	
	public int maxDepth() {
		return maxDepth(root, 0);
	}
	
	public T min() {
		if(root == null) {
			throw new IllegalStateException();
		}
		return min(root, root.value);
	}
	
	
	private Node<T> insert(Node<T> node, T value) {
		if(node == null) {
			return new Node<T>(value);
		} else {
			if(root.value.compareTo(value) >= 0) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
			return node;
		}
	}

	private boolean contains(Node<T> node, T value) {
		if(node == null) {
			return false;
		} else {
			if(node.value.compareTo(value) > 0) {
				return contains(node.left, value);
			} else if(node.value.compareTo(value) < 0) {
				return contains(node.right, value);
			} else {
				return true;
			}
		}
	}
	
	private int size(Node<T> node) {
		if(node == null) {
			return 0;
		} else {
			return 1 + size(node.left) + size(node.right);
		}
	}
	
	private int maxDepth(Node<T> node, int depth) {
		if(node == null) {
			return depth;
		} else {
			int leftDepth = maxDepth(node.left, depth + 1);
			int rightDepth = maxDepth(node.right, depth + 1); 
			return leftDepth >= rightDepth ? leftDepth : rightDepth;
		}
	}

	private T min(Node<T> node, T min) {
		if(node == null) {
			return min;
		} else {
			return min(node.left, node.value);
		}
	}

}

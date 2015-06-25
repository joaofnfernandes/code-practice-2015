package chapter4.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {
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
	
	public void delete(T value) {
		root = delete(root, value);
	}
	
	public String printPreOrder() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		printPreOrder(root, builder);
		builder.append("]");
		return builder.toString();
	}
	
	public String printInOrder() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		printInOrder(root, builder);
		builder.append("]");
		return builder.toString();
	}
	
	public String printPostOrder() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		printPostOrder(root, builder);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean isBalanced() {
		return isBalanced(root).isBalanced;
	}
	
	public T getSuccessor(T key) {
		Node<T> node = getNode(root, key);
		if(node != null && node.right != null) {
			T min = min(node.right, node.right.value);
			// no successor
			if(node.value.compareTo(min) == 0) {
				return null;
			} else {
				return min;
			}
		} else {
			return null;
		}
	}
	
 	private Node<T> insert(Node<T> node, T value) {
		if(node == null) {
			return new Node<T>(value);
		} else {
			if(node.value.compareTo(value) >= 0) {
				node.left = insert(node.left, value);
			} else  if(node.value.compareTo(value) < 0) {
				node.right = insert(node.right, value);
			}
			return node;
		}
	}

	private Node<T> getNode(Node<T> node ,T key) {
		if(node == null) {
			return null;
		} else if(node.value.compareTo(key) == 0) {
			return node;
		} else {
			Node<T> leftResult = getNode(node.left, key);
			if(leftResult != null) {
				return leftResult;
			}
			return getNode(node.right, key);
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

	private Node<T> delete(Node<T> node, T value) {
		if(node == null) {
			return node;
		}
		else if(node.value.compareTo(value) < 0) {
			node.right = delete(node.right, value);
		} else if(node.value.compareTo(value) > 0) {
			node.left = delete(node.left, value);
		} else {
			if(node.left == null && node.right == null) {
				// just make it disappear
				return null;
			} else if(node.left == null && node.right != null) {
				return node.right;
			} else if(node.left != null && node.right == null) {
				return node.left;
			} else {
				// find in order successor and swap its value
				T successor = min(node.right, node.value);
				node.value = successor;
				delete(node.right, successor);
			}
		}
		return node;
	}
	
	private void printPreOrder(Node<T> node, StringBuilder builder) {
		if(node != null) {
			if(builder.length() != 1) {
				builder.append(",");
			}
			builder.append(node.value);
			printPreOrder(node.left, builder);
			printPreOrder(node.right, builder);
		}
	}
	
	private void printInOrder(Node<T> node, StringBuilder builder) {
		if(node != null) {
			printInOrder(node.left, builder);
			if(builder.length() != 1) {
				builder.append(",");
			}
			builder.append(node.value);
			printInOrder(node.right, builder);
		}
	}
	
	private void printPostOrder(Node<T> node, StringBuilder builder) {
		if(node != null) {
			printPostOrder(node.left, builder);
			printPostOrder(node.right, builder);
			if(builder.length() != 1) {
				builder.append(",");
			}	
			builder.append(node.value);
		}
	}

	private BalancedTreeInfo isBalanced(Node<T> node) {
		if(node == null) {
			return new BalancedTreeInfo(true, 0);
		} else {
			BalancedTreeInfo leftTreeInfo = isBalanced(node.left);
			if(!leftTreeInfo.isBalanced) {
				leftTreeInfo.height++;
				return leftTreeInfo;
			}
			BalancedTreeInfo rightTreeInfo = isBalanced(node.right);
			if(!rightTreeInfo.isBalanced) {
				rightTreeInfo.height++;
				return rightTreeInfo;
			}
			if(leftTreeInfo.height - rightTreeInfo.height >= 0) {
				if(leftTreeInfo.height - rightTreeInfo.height > 1) {
					leftTreeInfo.isBalanced = false;
				}
				leftTreeInfo.height++;
				return leftTreeInfo;
			} else {
				if(rightTreeInfo.height - leftTreeInfo.height > 1) {
					rightTreeInfo.isBalanced = false;
				}
				rightTreeInfo.height++;
				return rightTreeInfo;
			}
		}
	}
	
	
}

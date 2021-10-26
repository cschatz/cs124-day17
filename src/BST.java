
public class BST<E> {
	
	private class BSTNode {
		E key;
		BSTNode left;
		BSTNode right;
	}
	
	// The BST class as a whole has only one
	// instance variable, representing the root
	private BST root;
	
	// Constructor
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
}





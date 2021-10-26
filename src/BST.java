
public class BST<E> {
	
	private class BSTNode {
		E key;
		BSTNode left;
		BSTNode right;
		
		// Constructor
		public BSTNode(E key) {
			this.key = key;
			left = null;
			right = null;
		}
	}
	
	// The BST class as a whole has only one
	// instance variable, representing the root
	private BSTNode root;
	
	// Constructor
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public void insert(E item) {
		BSTNode node = new BSTNode(item);
		// Edge case: this is the first node inserted
		// in an empty tree
		if (root == null) {
			root = node;
		} else {
			
		}
	}
	
}





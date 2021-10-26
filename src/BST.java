
public class BST<E extends Comparable<E>> {
	
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
			// Start a "current" reference at the root node...
			BSTNode current = root;
			// ... then walk down the tree to find a place
			// to insert
			while (true) {
				if (item.compareTo(current.key) < 0) {
					// go left
					if (current.left == null) {
						// found a place to insert, yaya!
						current.left = node;
						return;
					} else {
						// walk to the left
						current = current.left;
					}
				} else if (item.compareTo(current.key) > 0) {
					// go right
					if (current.right == null) {
						// found a place to insert, yaya!
						current.right = node;
						return;
					} else {
						// walk to the left
						current = current.right;
					}
				} else {
					// uh oh! duplicate!!!
					// do nothing
					System.out.println("Psst! You already added " + item + "...");
					return;
				}
			}
		}
	}
	
}





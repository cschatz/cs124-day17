
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
		
		public boolean isLeaf() {
			return (left == null && right == null);
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
	
	public boolean find(E target) {
		BSTNode current = root;
		while (true) {
			if (current == null) {
				return false;
			}
			else if (target.compareTo(current.key) == 0) {
				return true;
			}
			else if (target.compareTo(current.key) < 0) {
				current = current.left;
			} 
			else { // target.compareTo(current.key) > 0
				current = current.right;
			}
		}
	}
	
	private void displayHelper(BSTNode subtreeRoot) {
		// Carry out in-order traversal of everything
		// in the tree from subtreeRoot down
		// Remember: in-order means left, root, right
		
		// base case
		if (subtreeRoot == null)
			return;
		
		// traverse my left subtree
		displayHelper(subtreeRoot.left);
		
		// print the current root's key
		System.out.println(subtreeRoot.key);
		
		// traverse my right subtree
		displayHelper(subtreeRoot.right);
		
	}
	
	public void display() {
		displayHelper(root);
	}
	
	public void remove(E target) {
		// phase 1: search for the target
		
		// edge case: empty tree
		if (root == null)
			return;
		
		BSTNode current = root;
		BSTNode parent = null;
		// edge case: target is at the root
		if (target.compareTo(root.key) == 0) {
			// TO DO:
			// Handle this case
			
		}
		
		while (true) {
			if (current == null) {
				// Not found! Just give up
				return;
			}
			else if (target.compareTo(current.key) == 0) {
				// Found it! 
				// Stop the search process
				break;
			}
			else if (target.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		
		
		// Phase 2: do the removal
		// parent is set to the parent of the node we want to remove
		
		// Case A: current is a leaf
		if (current.isLeaf()) {
			// set the parent's child to null
			if (parent.left == current)
				parent.left = null;
			else
				parent.right = null;
		}
		
		// Case B: one of current's children is a leaf
		
		
	}
}
	





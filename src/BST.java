
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
		
		// Vase case
		if (subtreeRoot == null)
			return;
		
		// Traverse my left subtree
		displayHelper(subtreeRoot.left);
		
		// Print the current root's key
		System.out.println(subtreeRoot.key);
		
		// Traverse my right subtree
		displayHelper(subtreeRoot.right);
		
	}
	
	public void display() {
		displayHelper(root);
	}
	
	public void remove(E target) {
		// Phase 1 - Search for the target
		
		// Edge case: empty tree
		if (root == null)
			return;
		
		BSTNode current = root;
		BSTNode parent = null;

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
		
		
		// Phase 2 - Do the removal
		// New approach (modified after Thursday's class): For Case B and C, 
		//  we only need to copy a different node's element into the one being removed.
		
		// Case A: current is a leaf
		if (current.isLeaf()) {
			// TO DO:
			// Add code to handle the target being at the root
			
			// set the parent's child to null
			if (parent.left == current)
				parent.left = null;
			else
				parent.right = null;
		}
		
		// Case B: one of current's children is a leaf
		else if (current.left != null && current.left.isLeaf()) {
			// Copy the key from current's left child into its place,
			//  then remove the child link
			current.key = current.left.key;
			current.left = null;
		}
		else if (current.right != null && current.right.isLeaf()) {
			// Copy the key from current's right child into its place,
			//  then remove the child link
			current.key = current.right.key;
			current.right = null;
		}

		
		// Case C: current's children are both non-leaf nodes
		
		// TO DO:
		// Implement the rest of the remove() method, handling Case C
		
		
		
	}
	
	public int numNodes() {
		// TO DO:
		// Determine the total number of nodes in the whole tree
		// (Hint: You may want to make a recursive helper method.)
		
		return 42; // placeholder
	}
	
	public int numLeaves() {
		// TO DO:
		// Determine the total number of leaves in the whole tree
		// (Hint: You may want to make a recursive helper method.)
		
		return 42; // placeholder
	}

	public void printKeysWithinRange(E minimum, E maximum) {
		// TO DO:
		// Print out all keys in the BST that are within the given range,
		//  such that minimum <= key <= maximum
		// *** Important ***: Your method should run in O(K + log(N)) average time,
		//                    where K is the number of keys printed.
		//                    You can achieve this by logically traversing only SOME nodes in the tree
		// (Hint: You may want to make a recursive helper method.)
		
	}
	
	
	
	
}
	





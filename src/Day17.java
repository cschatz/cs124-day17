import java.util.List;

// Lab 3 - Task 1
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public int numDescendants(Node root) {
        // base case
    	if (root.children.isEmpty())
    		return 0;
    	int total = 0;
    	for (Node child : root.children) {
    		// add one for each child itself
    		// plus as many descendants as that child has
    		total += (1 + numDescendants(child));
    	}
    	return total;
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}


// Lab 3 - Task 2
class Solution2 {
    private boolean areMirrorImages(TreeNode leftTreeRoot, TreeNode rightTreeRoot) {
        // base case: no children
        if (leftTreeRoot == null && rightTreeRoot == null)
            return true;
        // base case: only one child
        if (leftTreeRoot == null || rightTreeRoot == null)
            return false;
        // base case: children don't match
        if (leftTreeRoot.val != rightTreeRoot.val)
            return false;
        
        // recursive leap: check if subtrees are mirror images in the right way
        return (areMirrorImages(leftTreeRoot.left, rightTreeRoot.right)
                    && 
                areMirrorImages(leftTreeRoot.right, rightTreeRoot.left));
        
    }
    public boolean isSymmetric(TreeNode root) {
        return areMirrorImages(root.left, root.right);
    }
}

// Lab 3 - Task 3 answers
/*
 * pre-order: 5, 2, 1, 4, 3, 9, 7, 6, 8, 10
 * 
 * in-order: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 * 
 * post-order: 1, 3, 4, 2, 6, 8, 7, 10, 9, 5
 * 
 * 
 * 
 * 
 */


public class Day17 {

	public static void main(String[] args) {
		BST<Integer> myTree = new BST<Integer>();
		myTree.insert(6);
		myTree.insert(10);
		myTree.insert(12);
		myTree.insert(3);
		myTree.insert(1);
		myTree.insert(5);
		myTree.insert(8);
		myTree.insert(9);
		
		// should print true
		System.out.println(myTree.find(5));
		System.out.println(myTree.find(3));
		System.out.println(myTree.find(12));
		
		// should print false
		System.out.println(myTree.find(4));
		System.out.println(myTree.find(2));
		System.out.println(myTree.find(11));
		
	}

}

package CtCi.Trees_and_Graphs;

public class Successor {
	public static TreeNode inOrderSuccessor(TreeNode node) {
		if (node.right != null) {
			return leftMostChild(node.right);
		} else {
			return properParent(node);
		}
	}
	
	public static TreeNode leftMostChild(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode current = node;
		
		while(current.left != null) {
			current = current.left;
		}
		
		return current;
	}
	
	public static TreeNode properParent(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		TreeNode parent = node.parent;
		TreeNode child = node;
		
		while(parent != null && parent.left != child) {
			child = parent;
			parent = child.parent;
		}
		
		return parent;
	}
	
	public static void main(String[] args) {
		/* Creates this binary search tree:
	     *          5
	     *        /   \
	     *       1     8
	     *      /     / \
	     *     0     6   9
	     */
		TreeNode root = new TreeNode(5);
        root.addLeftChild(1);
        root.left.addLeftChild(0);
        root.addRightChild(8);
        root.right.addLeftChild(6);
        root.right.addRightChild(9);
        
        System.out.println("Should be 6:    " + inOrderSuccessor(root));
        System.out.println("Should be 5:    " + inOrderSuccessor(root.left));
        System.out.println("Should be null: " + inOrderSuccessor(root.right.right));
	}
}

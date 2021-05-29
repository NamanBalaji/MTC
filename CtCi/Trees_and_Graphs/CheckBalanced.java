package CtCi.Trees_and_Graphs;

public class CheckBalanced {
	public static boolean checkBalanced(TreeNode root) {
		if (root == null) return true;
		int left, right;
		left = getHeight(root.left);
		right = getHeight(root.right);
		
		if (Math.abs(left - right ) <= 1 
			&& checkBalanced(root.left)
			&& checkBalanced(root.right)
			) {
			return true;
		}
		
		return false;
	}
	
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void main(String[] args) {
		/* Create this Tree:
	     *          5
	     *        /   \
	     *       1    -3
	     *      /     / \
	     *     0     2   4
	     */
		
		 TreeNode root = new TreeNode(5);
	     root.addLeftChild(1);
	     root.left.addLeftChild(0);
         root.addRightChild(-3);
         root.right.addLeftChild(2);
         root.right.addRightChild(4);
	     
	     System.out.println("Tree balanced: " + checkBalanced(root));
	}
}

package CtCi.Trees_and_Graphs;

public class ValidateBST {
	public static boolean isBST(TreeNode root) {
		return isBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBstHelper(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if(root.data <= min || root.data >= max) {
			return false;
		}
		
		return isBstHelper(root.left, min, root.data) && isBstHelper(root.right, root.data, max);
	}
	
	public static void main(String[] arg) {
		/* Creates this binary search tree:
	     *          5
	     *        /   \
	     *       1     8
	     *      /     / \
	     *     0     6   9
	     */
		TreeNode rootBST = new TreeNode(5);
        rootBST.addLeftChild(1);
        rootBST.left.addLeftChild(0);
        rootBST.addRightChild(8);
        rootBST.right.addLeftChild(6);
        rootBST.right.addRightChild(9);
        System.out.println("is BST: " + isBST(rootBST));
        
        /* Creates this Tree:
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
        System.out.println("is BST: " + isBST(root));
        
	}
}

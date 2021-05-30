package CtCi.Trees_and_Graphs;

public class FirstCommonAncestor {
	public static TreeNode firstCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		if (p.data < root.data && q.data < root.data) {
			return firstCommonAncestorBST(root.left, p, q);
		} else if (p.data > root.data && q.data > root.data) {
			return firstCommonAncestorBST(root.right, p, q);
		} else {
			return root;
		}
	}
	
	public static TreeNode fcaGeneral(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return null;
		}
		
		TreeNode ancestorP = p.parent;
		while(ancestorP != null) {
			TreeNode ancestorQ = q.parent;
			while(ancestorQ != null) {
				if (ancestorP == ancestorQ) {
					return ancestorP;
				}
				ancestorQ = q.parent;
			}
			ancestorP = p.parent;
		}
		return null;
	}
	
	public static void main(String[] args) {
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
	        
	        System.out.println("Common ancestor BST (should be 5): " + firstCommonAncestorBST(rootBST, rootBST.left, rootBST.right.right));
	        System.out.println("Common ancestor BST (should be 8): " + firstCommonAncestorBST(rootBST, rootBST.right, rootBST.right.left));
	        
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
	        
	        System.out.println("Common ancestor (should be 5): " + fcaGeneral(root, root.left, root.right.right));
	        System.out.println("Common ancestor (should be -3): " + fcaGeneral(root, root.right, root.right.left));
	}
}

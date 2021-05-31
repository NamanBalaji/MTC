package CtCi.Trees_and_Graphs;

public class CheckSubtree {
	//recursive 
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		} else if (isSameTree(s, t)) {
			return true; 
		} else {
			return isSameTree(s.left, t) || isSameTree(s.right, t);
		}
	}
	
	public static boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return s == null && t == null;
		} else if (s.data == t.data) {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		} else {
			return false;
		}
	}
	
	// iterative 
	public static boolean isSubtreeIterative(TreeNode s, TreeNode t) {
		StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        getPreorder(s, sb1);
        getPreorder(t, sb2);
        
        return sb1.indexOf(sb2.toString()) != -1;
	}
	
	 private static void getPreorder(TreeNode node, StringBuffer sb) {
	        if (node == null) {
	            sb.append("X");          // Add X representing null
	            return;
	        }
	        sb.append("#" + node.data);  // Add separator and root 
	        getPreorder(node.left, sb);  // Add left
	        getPreorder(node.right, sb); // Add right
	    }
	 
	 public static void main(String[] args) {
		 /* Create this Tree:
		     *          5
		     *        /   \
		     *       1    -3
		     *      /     / \
		     *     0     2   4
		     */
			
			 TreeNode s = new TreeNode(5);
		     s.addLeftChild(1);
		     s.left.addLeftChild(0);
	         s.addRightChild(-3);
	         s.right.addLeftChild(2);
	         s.right.addRightChild(4);
	         
	         /* Creates this binary search tree:
	 	     *          5
	 	     *        /   \
	 	     *       1     8
	 	     *      /     / \
	 	     *     0     6   9
	 	     */
	 		TreeNode t = new TreeNode(5);
	         t.addLeftChild(1);
	         t.left.addLeftChild(0);
	         t.addRightChild(8);
	         t.right.addLeftChild(6);
	         t.right.addRightChild(9);
	         
	         TreeNode r = new TreeNode(5);
	         
	         System.out.println("Contains tree (should be false): " + isSubtree(s, r));
	         System.out.println("Contains tree (should be false): " + isSubtreeIterative(s, r));
	         System.out.println("Contains tree (should be true ): " + isSubtree(s, s));
	         System.out.println("Contains tree (should be true ): " + isSubtreeIterative(t, t));
	 }
}

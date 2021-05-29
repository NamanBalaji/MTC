package CtCi.Trees_and_Graphs;

public class MinimalTree {
	public static TreeNode createBST(int[] sortedArray) {
		if (sortedArray == null) {
			return null;
		}
		return createBstHelper(sortedArray, 0, sortedArray.length - 1);
	}
	
	public static TreeNode createBstHelper(int[] sortedArray, int startIndex, int endIndex) {
		if (startIndex > endIndex) return null;
		
		int mid = (startIndex + endIndex) / 2;
		TreeNode root = new TreeNode(sortedArray[mid]);
        root.left  = createBstHelper(sortedArray, startIndex, mid - 1);
        root.right = createBstHelper(sortedArray, mid + 1, endIndex);
        
        return root;
	}
	
	public static void main(String[] args) {
		 int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7 };
	     TreeNode BST = MinimalTree.createBST(sortedArray);
	     System.out.print("In-Order print of tree: ");
	     Tree.printInOrder(BST);
	}
}

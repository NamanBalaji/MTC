package CtCi.Trees_and_Graphs;

import java.util.*;
public class PathWithSum {
	
	// checks if there exist any path with given sum. The path need to start at the root and end at a leaf
	public static boolean pathExist(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null && sum - root.data == 0) {
			return true;
		} else {
			return pathExist(root.left, sum - root.data) || pathExist(root.right, sum - root.data);
		}
	}
	
	//find all paths with given sum. The path need to start at the root and end at a leaf
	public static List<List<Integer>> getFullPaths(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<>();
		findFullPaths(root, sum, new ArrayList<Integer>(), paths);
		return paths;
	}
	
	public static void findFullPaths(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> paths) {
		if (root == null) {
			return;
		}
		
		current.add(root.data);
		if (root.left == null && root.right == null && sum - root.data == 0) {
			paths.add(current);
			return;
		}
		
		findFullPaths(root.left, sum - root.data, new ArrayList<Integer>(current), paths);
		findFullPaths(root.right, sum - root.data, new ArrayList<Integer>(current), paths);
		
	}
	
	//find all paths with given sum. The path does not need to start or end at the root or a leaf
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		
		/* Count paths with sum starting from the root. */
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		
		/* Try the nodes on the left and right. */
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	/* Returns the number of paths with this sum starting from this node. */
	public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
		if (node == null) return 0;
	
		currentSum += node.data;
		
		int totalPaths = 0;
		if (currentSum == targetSum) { // Found a path from the root
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum); // Go left
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum); // Go right
		
		return totalPaths;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, -14));
		System.out.println(getFullPaths(root, 3));
	}
}

package CtCi.Trees_and_Graphs;

public class TreeNode {
	public TreeNode left  = null;
	public TreeNode right  = null;
	public TreeNode parent  = null;
	public int data;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public void addLeftChild(int data) {
		TreeNode node = new TreeNode(data);
		left = node;
		node.parent = this;
	}
	
	public void addRightChild(int data) {
		TreeNode node = new TreeNode(data);
		right = node;
		node.parent = this;
	}
	
	@Override
	public String toString( ) {
		return String.valueOf(data) + " ";
	}
}

package CtCi.Trees_and_Graphs;
import java.util.*;

public class Tree {
	 public static void printPreOrder(TreeNode node) {
	        if (node != null) {
	            System.out.print(node); // our toString() method will be invoked here
	            printPreOrder(node.left);
	            printPreOrder(node.right);
	        }
	    }

	    public static void printInOrder(TreeNode node) {
	        if (node != null) {
	            printInOrder(node.left);
	            System.out.print(node); // our toString() method will be invoked here
	            printInOrder(node.right);
	        }
	    }

	    public static void printPostOrder(TreeNode node) {
	        if (node != null) {
	            printPostOrder(node.left);
	            printPostOrder(node.right);
	            System.out.print(node); // our toString() method will be invoked here
	        }
	    }

	    /* Prints tree level 0, 1, ... n */
	    public static void printLevelOrder(TreeNode root) {
	        ArrayDeque<TreeNode> deque = new ArrayDeque<>(); // use deque as a queue
	        deque.add(root);
	        while (!deque.isEmpty()) {
	            TreeNode n = deque.removeFirst();
	            System.out.print(n + " ");
	            if (n.left != null) {
	                deque.addLast(n.left);
	            }
	            if (n.right != null) {
	                deque.addLast(n.right);
	            }
	        }
	    }
}

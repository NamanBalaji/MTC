package BinarySearchTrees;

import java.util.ArrayList;

import CtCi.Trees_and_Graphs.Tree;
import CtCi.Trees_and_Graphs.TreeNode;

public class BSTToBalancedBST {
    private static ArrayList<Integer> inOrder;

    public static TreeNode balance(TreeNode root){
        inOrder = new ArrayList<>();
        inorderTravrersal(root);

        int nodes = inOrder.size();

        return buildTree(0, nodes-1);
    }

    private static void inorderTravrersal(TreeNode root){
        if(root == null) return;
        inorderTravrersal(root.left);
        inOrder.add(root.data);
        inorderTravrersal(root.right);
    }

    private static TreeNode buildTree(int low, int high){
        if(low > high) return null;

        int mid = (low + high)/2;

        TreeNode root =  new TreeNode(inOrder.get(mid));
        root.left = buildTree(low, mid-1);
        root.right = buildTree(mid+1, high);

        return root;
    } 

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(5);

        TreeNode newRoot = balance(root);
        Tree.printPreOrder(newRoot);
    }
}

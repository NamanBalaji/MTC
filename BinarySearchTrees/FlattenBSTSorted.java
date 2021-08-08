package BinarySearchTrees;

import CtCi.Trees_and_Graphs.TreeNode;

public class FlattenBSTSorted {

    private static TreeNode prev;

    public static TreeNode flatten(TreeNode root){
        if(root == null) return root;
        TreeNode temp = new TreeNode(-1);
        prev = temp;
        inOrder(root);
        prev.left = null;
        prev.right = null;
        return temp.right;
    }
    private static void inOrder(TreeNode root){
        if(root == null) return;
    
        inOrder(root.left);
        if(prev != null){
            prev.left = null;
            prev.right = root;
            prev = root;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode newRoot = flatten(root);
        while(newRoot != null){
            System.out.print(newRoot.data + "->");
            newRoot  = newRoot.right;
        }
    }
}

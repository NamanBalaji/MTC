package Topics.BinarySearchTrees;

import CtCi.Trees_and_Graphs.*;
import java.util.*;

public class BinaryTreeToBST {
    
    private static ArrayList<Integer> dataInorder;
    private static int counter = 0;
    public static TreeNode convert(TreeNode root){
        if(root == null) return null;

        dataInorder = new ArrayList<>();

        inorderTraversal(root);

        Collections.sort(dataInorder);
        inorderReplace(root);

        return root;
    } 

    private static void inorderTraversal(TreeNode root){
        if(root == null) return;

        inorderTraversal(root.left);
        dataInorder.add(root.data);
        inorderTraversal(root.right);
    } 

    private static void inorderReplace(TreeNode root){
        if(root == null || counter >= dataInorder.size()) return;

        inorderReplace(root.left);
        root.data = dataInorder.get(counter);
        counter += 1;
        inorderReplace(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
	    root.addLeftChild(2);
	    root.left.addLeftChild(4);
        root.addRightChild(3);
        root.right.addLeftChild(7);

        TreeNode BSTRoot = convert(root);
        Tree.printInOrder(BSTRoot);
    }

}

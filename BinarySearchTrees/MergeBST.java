package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Collections;

import CtCi.Trees_and_Graphs.Tree;
import CtCi.Trees_and_Graphs.TreeNode;

public class MergeBST {
    private static ArrayList<Integer> tree1;
    private static ArrayList<Integer> tree2;
    private static ArrayList<Integer> mergeTree; 

    public static TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1 != null && root2 == null) return root1;
        if(root1 == null && root2 != null) return root2;
        tree1 = new ArrayList<>();
        tree2 = new ArrayList<>();
        inOrder(root1, tree1);
        inOrder(root2, tree2);
        mergeTree = new ArrayList<>();
        for(int n : tree1){
            mergeTree.add(n);
        }
        for(int n: tree2){
            mergeTree.add(n);
        }
        Collections.sort(mergeTree);

        int nodes = mergeTree.size();

        return buildTree(0, nodes-1);
    }

    private static TreeNode buildTree(int low, int high){
        if(low > high) return null;

        int mid = (low + high)/2;

        TreeNode root =  new TreeNode(mergeTree.get(mid));
        root.left = buildTree(low, mid-1);
        root.right = buildTree(mid+1, high);

        return root;
    } 

    private static void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(100);
        root1.left = new TreeNode(50);
        root1.right = new TreeNode(300);
        root1.left.left =  new TreeNode(20);
        root1.left.right = new TreeNode(70);

        TreeNode root2 = new TreeNode(80);
        root2.left = new TreeNode(40);
        root2.right = new TreeNode(120);
        
        TreeNode newRoot = merge(root1, root2);
        Tree.printInOrder(newRoot);
    }
}

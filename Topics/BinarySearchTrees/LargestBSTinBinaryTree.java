package Topics.BinarySearchTrees;

import CtCi.Trees_and_Graphs.TreeNode;

public class LargestBSTinBinaryTree {
    public static int largestBST(TreeNode root){
        MinMax m = largest(root);
        return m.size;
    }

    private static MinMax largest(TreeNode root){
        if(root == null){
            return new MinMax();
        }
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax =largest(root.right);

        MinMax m = new MinMax();

        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min <= root.data)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }

        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;

        m.min = root.left != null ? leftMinMax.min : root.data;
        m.max = root.right != null ? rightMinMax.max : root.data;

        return m;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
	    root.addLeftChild(2);
	    root.left.addLeftChild(4);
        root.addRightChild(3);
        root.right.addLeftChild(7);

        int max  = largestBST(root);
        System.out.println("Largest BST is of size " + max);
    }
}

class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;
    
    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }
}
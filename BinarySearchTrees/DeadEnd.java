package BinarySearchTrees;

import CtCi.Trees_and_Graphs.TreeNode;

public class DeadEnd {
    private static boolean checkDeadEnd(TreeNode root, int min, int max){
        
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return  (root.data == min +1 && root.data == max-1) ? true : false;
        }

        boolean left = checkDeadEnd(root.left, min, root.data);
        boolean right = checkDeadEnd(root.right, root.data, max);
        return left||right;
    }

    public static boolean isDeadEnd(TreeNode root){
        return checkDeadEnd(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new  TreeNode(11);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.right = new TreeNode(3);
        root.left.left.right.right = new TreeNode(4);

        System.out.println(isDeadEnd(root));
    }
}

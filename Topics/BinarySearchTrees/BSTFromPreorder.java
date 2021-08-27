package Topics.BinarySearchTrees;

import CtCi.Trees_and_Graphs.*;

public class BSTFromPreorder {

    public static TreeNode constructTree(int[] preorder){
        int size = preorder.length;
        if(size==0)
            return null;
        

        TreeNode root = new TreeNode(preorder[0]);

        if(size ==1)
            return root;
        

        helper(preorder, size, 1, root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    private static int helper(int[] preorder, int size, int pos, TreeNode root, int min, int max){
        if(pos >= size || preorder[pos] < min || preorder[pos] > max){
            return pos;
        }

        if(preorder[pos] < root.data){
            root.left = new TreeNode(preorder[pos]);
            pos += 1;
            pos = helper(preorder, size, pos, root.left, min, root.data -1);
        }

        if(pos >= size || preorder[pos] < min || preorder[pos] > max){
            return pos;
        }

        root.right = new TreeNode(preorder[pos]);
        pos += 1;
        pos  = helper(preorder, size, pos, root.right, root.data +1, max);
        return pos;
    }

    public static void main(String[] args) {
        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        TreeNode root = constructTree(pre);
        Tree.printPreOrder(root);
    }
}

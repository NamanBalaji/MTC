package Topics.BinarySearchTrees;

import CtCi.Trees_and_Graphs.Tree;
import CtCi.Trees_and_Graphs.TreeNode;

public class ConstructBSTFromPreOrder {
    
    public static TreeNode construct(int[] pre){
        int start = 0;
        TreeNode root = buildTree(pre, start, pre.length - 1);
        return root;
    }

    private static TreeNode buildTree(int[] pre, int min, int max){
        if(min > max) return null;
        TreeNode node = new TreeNode(pre[min]);
        int i;
        for(i=min+1; i<= max; i++){
            if(pre[i]>pre[min]) 
                break;
        }
        node.left = buildTree(pre, min+1, i-1);
        node.right = buildTree(pre, i, max);
        return node;
    }

    public static void main(String[] args) {
        int pre[] = { 40, 30, 35, 80, 100 };
        TreeNode root = construct(pre);
        Tree.printPreOrder(root);
    }
}

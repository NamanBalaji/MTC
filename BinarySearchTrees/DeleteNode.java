package BinarySearchTrees;
import CtCi.Trees_and_Graphs.Tree;
import CtCi.Trees_and_Graphs.TreeNode;

public class DeleteNode {
    public static TreeNode deleteNode(TreeNode root, int key){
        
        if(root==null){
            return null;
        }
        
        if(root.data<key){
            root.right=deleteNode(root.right,key);
        }else if(root.data>key){
            root.left=deleteNode(root.left,key);
        }else{
            if(root.left==null || root.right==null){
                return root.left!=null ? root.left:root.right;
            }
            
            int maxData=maximum(root.left);
            root.data=maxData;
            root.left=deleteNode(root.left,maxData);
        }
        
        return root;
    }

    private static int maximum(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        TreeNode rootBST = new TreeNode(5);
        rootBST.addLeftChild(1);
        rootBST.left.addLeftChild(0);
        rootBST.addRightChild(8);
        rootBST.right.addLeftChild(6);
        rootBST.right.addRightChild(9);

        TreeNode newRoot = deleteNode(rootBST, 6);
        Tree.printLevelOrder(newRoot);
    }
}

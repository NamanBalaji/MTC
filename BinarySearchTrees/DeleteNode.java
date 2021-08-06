package BinarySearchTrees;
import CtCi.Trees_and_Graphs.Tree;
import CtCi.Trees_and_Graphs.TreeNode;

public class DeleteNode {
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;
        if(root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.data > key){
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left != null && root.right !=null){
                TreeNode current  = root.right;
                TreeNode temp = current;
                while(temp.left != null){
                    temp = temp.left;
                }
                temp.left = root.left;
                return current;
            }
            return root.left == null ? root.right : root.left;
        }
        return root;
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

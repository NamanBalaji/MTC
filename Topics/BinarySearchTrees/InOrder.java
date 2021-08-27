package Topics.BinarySearchTrees;
import CtCi.Trees_and_Graphs.TreeNode;
import CtCi.Trees_and_Graphs.Tree;

public class InOrder {
    static TreeNode pre;
    static TreeNode succ;

    public  static void inorder(TreeNode root, int key){
        if(root == null) return;

        if(key == root.data){
            if(root.right != null){
                succ = root.right;
                while(succ.left != null)
                    succ = succ.left;
            }

            if(root.left != null){
                pre = root.left;
                while(pre.right != null)
                    pre = pre.right;
            }
        } else if (root.data < key){
            pre = root; 
            inorder(root.right, key);
        } else{
            succ = root;
            inorder(root.left, key);
        }
    }
    
    public static void main(String[] args) {
        TreeNode rootBST = new TreeNode(5);
        rootBST.addLeftChild(1);
        rootBST.left.addLeftChild(0);
        rootBST.addRightChild(8);
        rootBST.right.addLeftChild(6);
        rootBST.right.addRightChild(9);

        inorder(rootBST, 8);

        if(pre == null && succ == null){
            System.out.println("Something went wrong");
        }
        System.out.println("Inorder successor is " + succ.data);
        System.out.println("Inorder predecessor is " + pre.data);
    }
}

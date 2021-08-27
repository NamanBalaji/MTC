package Topics.BinarySearchTrees;

import java.util.HashSet;
import java.util.Set;

import CtCi.Trees_and_Graphs.TreeNode;

public class BrothersFromDifferentRoot {
    private static Set<Integer> s1;
    private static Set<Integer> s2;

    static int countPairs(TreeNode root1, TreeNode root2, int x){
        s1 = new HashSet<>();
        s2 = new HashSet<>();
        
        createSet(root1, s1);
        createSet(root2, s2);

        int count = 0;
        for(int n : s1){
            if(s2.contains(x-n)){
                count++;
            }
        }
        return count;
    }

    private static void createSet(TreeNode root, Set<Integer> set){
        if(root == null) return;

        createSet(root.left, set);
        set.add(root.data);
        createSet(root.right, set);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left =  new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left= new TreeNode(6);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(15);
        root2.left.left =  new TreeNode(3);
        root2.left.right = new TreeNode(8);
        root2.right.left= new TreeNode(11);
        root2.right.right = new TreeNode(18);

        System.out.println(countPairs(root1, root2, 16));
    }
}

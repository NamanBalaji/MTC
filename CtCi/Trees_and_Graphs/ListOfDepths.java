package CtCi.Trees_and_Graphs;
import java.util.*;

public class ListOfDepths {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()) {
        	int nodesInLevel = deque.size();
        	List<Integer> level = new ArrayList<>(nodesInLevel);
        	for (int i = 0; i < nodesInLevel; i++) {
                TreeNode n = deque.remove();
                level.add(n.data);
                if (n.left != null) {
                    deque.add(n.left);
                }
                if (n.right != null) {
                    deque.add(n.right);
                }
            }
          lists.add(level);
        }
        return lists;
	}
	
	public static void main(String[] args) {
		
		/* Creates this binary search tree:
	     *          5
	     *        /   \
	     *       1     8
	     *      /     / \
	     *     0     6   9
	     */
		
		TreeNode root = new TreeNode(5);
        root.addLeftChild(1);
        root.left.addLeftChild(0);
        root.addRightChild(8);
        root.right.addLeftChild(6);
        root.right.addRightChild(9);
        
        List<List<Integer>> lists = ListOfDepths.levelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.format("\nLevel %d: ", i);
            for (Integer num : list) {
                System.out.print(num + "\t");
            }
        }
    }
}

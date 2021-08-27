package DailyCodingProblem.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

public class Day3 {

    public static String serialize(Node root){
        if(root == null) {
            return null;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        List<String> l = new ArrayList<>();
        while(!s.isEmpty()){
            Node t= s.pop();
            if(t == null){
                l.add("#");
            } else{
                l.add("" +t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }


    public static Node deserialize(String data){
        if(data == null) return null;
        int t = 0;
        String[] arr = data.split(",");
        return deserializeHelper(arr, t);
    }

    private static Node deserializeHelper(String[] arr, int t){
        if(arr[t].equals("#")){
            return null;
        }
        Node root = new Node(Integer.parseInt(arr[t]));
        root.left = deserializeHelper(arr, t+1);
        root.right = deserializeHelper(arr, t+2);
        return root;
    }

    static void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        String sTree = serialize(root);
        System.out.println(sTree);
        Node temp = deserialize(sTree);
        inorder(temp);

    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {this.val = val;}
}

//Time: O(n)
//Space: O(n)
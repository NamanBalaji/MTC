package Topics.Greedy;

import java.util.PriorityQueue;

import java.util.Comparator;

class HuffmanNode{
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int data, char c){
        this.data = data;
        this.c = c;
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
 
        return x.data - y.data;
    }
}

public class HuffmanEncoding {
    
    public static void printCodes(HuffmanNode root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + ":" + s);
            return;
        }

        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void encode(char[] chars, int[] freq, int n){
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for(int i=0;i<n;i++){
            HuffmanNode h = new HuffmanNode(freq[i], chars[i]);
            h.left = null;
            h.right=null;
            pq.add(h);
        }

        HuffmanNode root = null;

        while(pq.size() > 1){
            HuffmanNode x = pq.peek();
            pq.poll();

            HuffmanNode y = pq.peek();
            pq.poll();

            HuffmanNode f = new HuffmanNode(x.data + y.data, '-');
            f.left = x;
            f.right = y;
            root  = f;

            pq.add(f);
        }

        printCodes(root, "");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        encode(chars, freq, n);
    }
}

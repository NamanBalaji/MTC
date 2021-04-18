package CtCi.LinkedList;

public class KthFromEnd {
    public static LinkedListNode kthFromEnd(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i=0; i< k; i++){
            if (p2 == null) return null;
            p2 = p2.next;
        }
        while(p2.next!= null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); 
        LinkedListNode head = first;
        LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
        LinkedListNode ans = kthFromEnd(head, 5);
        System.out.println(ans.data);
    }
}

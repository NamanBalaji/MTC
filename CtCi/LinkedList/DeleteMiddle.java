package CtCi.LinkedList;

public class DeleteMiddle{
    public static void deleteMiddle(LinkedListNode node){
        if (node == null || node.next == null) {
			return;
        }    
        node.data = node.next.data;
        node.next = node.next.next;
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
        deleteMiddle(head.next.next.next);
        System.out.println(head.printForward());
    }
}
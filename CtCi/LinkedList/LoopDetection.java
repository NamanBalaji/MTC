package CtCi.LinkedList;

public class LoopDetection {
    public static LinkedListNode loopBeginning(LinkedListNode n) {
        LinkedListNode slow = n;
        LinkedListNode fast = n;
        while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		slow = n; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		
		return fast;
    }
    public static void main(String[] args) {
        int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = loopBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
    }
}

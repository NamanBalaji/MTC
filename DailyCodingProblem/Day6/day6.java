package DailyCodingProblem.Day6;

//An XOR linked list is a more memory efficient doubly linked list. 
//Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. 
//Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

public class day6 {
    
}

class XorNode {
    int val;
    int both;
    XorNode(int val){
        this.val = val;
    }
}

class XorLinkedList {
    XorNode head, tail;

    XorLinkedList(){
        this.head = null;
        this.tail = null;
    }

    void add(XorNode node){
        if(this.head == null){
            this.head = this.tail = node;
        } else {
            this.tail.both  = System.identityHashCode(node) ^ this.tail.both;
            node.both = System.identityHashCode(this.tail);
            this.tail = node;
        }
    }

    XorNode get(int index) {
        int preId = 0;
        int nextId = 0;
        XorNode node = this.head;
        for(int i = 0; i<index; i++){
            nextId  = preId ^ node.both;
            if(nextId != 0){
                preId = System.identityHashCode(node);
                node = getNode(nextId);
            } else {
                System.out.println("Index out of range");
                return null;
            }
            return node;
        }
    }

    //add runs in O(1)
    //get runs in O(N)
}
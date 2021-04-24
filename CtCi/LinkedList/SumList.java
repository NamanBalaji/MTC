package CtCi.LinkedList;

import java.util.Stack;

public class SumList {
    public static int sumList(LinkedListNode n1, LinkedListNode n2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int operand1 = 0; 
        int operand2 = 0;
        int result = 0;
        while(n1!=null){
            s1.push(n1.data);
            n1 = n1.next;
        }
        while(n2!=null){
            s2.push(n2.data);
            n2 = n2.next;
        }

        int s1len = s1.size();
        int s2len = s2.size();
       
        for (int i=0; i< s1len; i++){
            operand1 = operand1 + (s1.pop() * (int)Math.pow(10, 3-i-1));
        }
        for (int i=0; i< s2len; i++){
            operand2 = operand2 + (s2.pop() * (int)Math.pow(10, 3-i-1));
        }

        result = operand1+operand2;
        return result;
    }

    public static void main(String[] args) {
        LinkedListNode la1 = new LinkedListNode(7);
		LinkedListNode la2 = new LinkedListNode(1);
        LinkedListNode la3 = new LinkedListNode(6);
        LinkedListNode lb1 = new LinkedListNode(5);
        LinkedListNode lb2 = new LinkedListNode(9);
        LinkedListNode lb3 = new LinkedListNode(2);

        la1.next = la2; la2.next = la3; la3.next = null;
        lb1.next = lb2; lb2.next = lb3; lb3.next = null;
        System.out.println(sumList(la1, lb1));
    }
}

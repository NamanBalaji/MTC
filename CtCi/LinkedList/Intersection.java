package CtCi.LinkedList;

public class Intersection {

    public static int size(LinkedListNode n){
        int s  = 0;
        if(n == null) return s;
        while(n != null){
            n = n.next;
            s++;
        }
        return s;
    }
    public static LinkedListNode intersection(LinkedListNode n1, LinkedListNode n2){
        int s1 = size(n1);
        int s2 =  size(n2);
        int difference = 0;

        if(s1<s2){
            difference = s2-s1;
            int counter = 0; 
            while(counter!= difference){
                n2 = n2.next;
                counter++;
            }
        } else{
            difference = s1-s2;
            int counter = 0; 
            while(counter!= difference){
                n1 = n1.next;
                counter++;
            }
        }
        
        while(n1 != n2){
            n1 = n1.next;
            n2= n2.next;
        }

        return n1;
    }

    public static void main(String[] args) {
        LinkedListNode la1 = new LinkedListNode(7);
		LinkedListNode la2 = new LinkedListNode(1);
        LinkedListNode la3 = new LinkedListNode(6);
        LinkedListNode lb1 = new LinkedListNode(5);
        LinkedListNode lb2 = new LinkedListNode(9);
        LinkedListNode lb3 = new LinkedListNode(2);
        LinkedListNode lb4 = new LinkedListNode(8);
        LinkedListNode lb5 = new LinkedListNode(5);
        LinkedListNode lab1 = new LinkedListNode(7);
		LinkedListNode lab2 = new LinkedListNode(1);
        LinkedListNode lab3 = new LinkedListNode(6);
        LinkedListNode lab4 = new LinkedListNode(5);

        lab1.next = lab2; lab2.next = lab3; lab3.next = lab4; lab4.next = null;
        la1.next = la2; la2.next = la3; la3.next = lab1;
        lb1.next = lb2; lb2.next = lb3; lb3.next = lb4; lb4.next = lb5; lb5.next = lab1;
        LinkedListNode intersectionPoint = intersection(la1, lb1);
        System.out.println(intersectionPoint.data);
    }
}

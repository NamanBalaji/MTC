package Greedy;

import java.util.*;

public class PageFaultLRU {
    class Node {
        Node prev,next;
        int key,value;
        Node(int _key, int _value)
        {
            key = _key;
            value = _value;
        }
    }

    Node head = new Node(0,0), tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    int pageFault; 

    public PageFaultLRU(int cap){
        capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            remove(map.get(key));
        } else{
            pageFault++;
        }
        if(map.size()==capacity)
        {
            remove(tail.prev);
        }
        insert(new Node(key,value));
        
    }
    private void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node)
    {
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public static void main(String[] args) {
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        PageFaultLRU lru = new PageFaultLRU(4);
        for(int i=0; i<pages.length; i++){
            lru.put(pages[i], pages[i]);
        }
        System.out.println(lru.pageFault);
    }
}

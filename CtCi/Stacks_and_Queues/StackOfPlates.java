package CtCi.Stacks_and_Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackOfPlates {
    public int capacity = 0;
    public List<Deque<Integer>>list = null;

    public StackOfPlates(int capacity){
        this.capacity = capacity;
        list = new LinkedList<>();
    }

    public void push(int val){
        if (list.isEmpty() || list.get(list.size()-1).size() == capacity){
            Deque<Integer> s = new LinkedList<>();
            list.add(s);
        }
        list.get(list.size()-1).add(val);
    }

    public int pop() {
        if(list.isEmpty()){
            System.out.println("No element present in stack");
            return -1;
        }
        int val = list.get(list.size()-1).pop();
        if(list.get(list.size()-1).isEmpty()){
            list.remove(list.get(list.size()-1));
        }
        return val;
    }

    public int peek() {
        if(list.isEmpty()){
            System.out.println("No element present in stack");
            return -1;
        }
        return list.get(list.size()-1).pop();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        int size = 0;
        for(Deque<Integer>s : list){
            size = s.size()+size;
        }
        return size;
    }
}

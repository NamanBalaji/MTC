package CtCi.Stacks_and_Queues;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    public Deque<Integer> stack = null;
    public Deque<Integer> min = null;

    public MinStack(){
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val){
        stack.push(val);
        if(min.isEmpty()){
            min.push(val);
        }
        else{
            int minValue = min.peek();
            if(minValue < val){
                min.push(minValue);
            }
            else{
                min.push(val);
            }
        }
    }

    public int pop(){
        min.pop();
        return stack.pop();
    }

    public int min(){
        return min.peek();
    }
}

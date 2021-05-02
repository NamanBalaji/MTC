package CtCi.Stacks_and_Queues;

import java.util.Deque;
import java.util.LinkedList;

public class QueueViaStacks {
    Deque<Integer> stack = new LinkedList<>();

    public void offer(int val){
        stack.push(val);
    }

    public int poll(){
        Deque<Integer> tempStack1 = new LinkedList<>();
        // copy elements from original stack to temp stack in reverse
        while(!stack.isEmpty()){
            tempStack1.push(stack.pop());
        }

        int val = tempStack1.pop();

        // after pop copy elements back to original stack in reverse order
        while(!tempStack1.isEmpty()){
            stack.push(tempStack1.pop());
        }

        return val;
    }

    public int peek(){
        Deque<Integer> tempStack1 = new LinkedList<>();
        // copy elements from original stack to temp stack in reverse
        while(!stack.isEmpty()){
            tempStack1.push(stack.pop());
        }

        int val = tempStack1.peek();

        // after pop copy elements back to original stack in reverse order
        while(!tempStack1.isEmpty()){
            stack.push(tempStack1.pop());
        }

        return val;
    }
}

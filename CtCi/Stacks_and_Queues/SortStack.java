package CtCi.Stacks_and_Queues;

import java.util.Deque;
import java.util.LinkedList;

public class SortStack {
   
    public static Deque<Integer> sortStack(Deque<Integer> stack){
        Deque<Integer> tempStack = new LinkedList<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek()>temp){
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return stack;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(8);

        Deque<Integer> sortedStack = sortStack(stack);
        System.out.println(sortedStack.toString()); 
    }
}

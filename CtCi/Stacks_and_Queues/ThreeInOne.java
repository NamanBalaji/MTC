package CtCi.Stacks_and_Queues;

public class ThreeInOne {
    public int arr[] = null;
    public int pointers[] = null;
    int totalCapacity = 0;
    public ThreeInOne(int totalCapacity){
        this.totalCapacity = totalCapacity;
        arr = new int[totalCapacity];
        pointers = new int[3];
        pointers[0] = -1;
        pointers[1] = totalCapacity/3 -1;
        pointers[2] = totalCapacity/3 *2 -1;
    }

    public void push(int val, int stackNumber){
        if (pointers[stackNumber+1] == (totalCapacity/3) * (stackNumber+1)){
            System.out.println("Stack full");
            return;
        }
        pointers[stackNumber]++;
        arr[pointers[stackNumber]] = val;
    }

    public int pop(int stackNumber){
        if( this.size(stackNumber) == 0){
            System.out.println("Stack is already empty.");
            return -1;
        }
        int val = arr[pointers[stackNumber]];
        pointers[stackNumber]--;
        return val;
    }

    public int peek(int stackNumber){
        return arr[pointers[stackNumber]];
    }

    public int size(int stackNumber){
        return pointers[stackNumber] - totalCapacity/3 *stackNumber +1;
    }
}

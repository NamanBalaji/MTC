package Topics.BinarySearchTrees;

public class ConflictingAppointment {
    static void printConflicting(Interval appt[]){
        Interval tree = new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE);
        IntervalNode root =  null;
        root = tree.insert(root, appt[0]);

        for(int i=1; i<appt.length; i++){
            Interval res = tree.overlapSearch(root, appt[i]);

            if(res != null){
                System.out.print("[" + appt[i].low +"," + appt[i].high + "] Conflicts with [" + res.low + "," + res.high + "]\n");
            }
            root = tree.insert(root, appt[i]);
        }
    }

    public static void main(String[] args) {
        Interval appt[] = new Interval[6];
        appt[0] = new Interval(1, 5);
        appt[1] = new Interval(3, 7);
        appt[2] = new Interval(2, 6);
        appt[3] = new Interval(10, 15);
        appt[4] = new Interval(5, 6);
        appt[5] = new Interval(4, 100);

        printConflicting(appt);
    }
}

class Interval {

    int low;
    int high;

    Interval(int low, int high){
        this.low = low;
        this.high = high;
    }

    IntervalNode insert(IntervalNode root, Interval i){
        if(root == null) return new IntervalNode(i);
        int l = root.i.low;
        if (i.low < l)
            root.left = insert(root.left, i);
        else
            root.right = insert(root.right, i);
        if (root.max < i.high)
            root.max = i.high;
        return root;
    }

    boolean doOverlap(Interval i1, Interval i2){
        if (i1.low < i2.high && i2.low < i1.high)
            return true;
         
        return false;
    }

    Interval overlapSearch(IntervalNode root, Interval i){
        if (root == null) return null;
        if (doOverlap(root.i, i))
            return root.i;
        
        if (root.left != null && root.left.max >= i.low)
            return overlapSearch(root.left, i);

        return overlapSearch(root.right, i);
    }
}

class IntervalNode {
    Interval i;
    int max;
    IntervalNode left, right;

    IntervalNode(Interval i){
        this.i = i;
        this.max = i.high;
        this.left = this.right = null;
    }
}
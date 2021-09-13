package DailyCodingProblem.Day5;

//cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
//For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
//Implement car and cdr.


public class Day5 {
    static int car(Pair p){
        return p.a;
    }
    
    static int cdr(Pair p){
        return p.b;
    }

    public static void main(String[] args) {
        System.out.println(car(new Pair(3, 4)));
        System.out.println(cdr(new Pair(3, 4)));
    }
}

class Pair {
    int a;
    int b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}
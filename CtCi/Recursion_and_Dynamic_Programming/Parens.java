package CtCi.Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class Parens {
    public static ArrayList<String> parens(int n){
        ArrayList<String> result = new ArrayList<>();
        getParens(result, "", 0, 0, n);
        return result;
    } 
    public static void getParens(ArrayList<String> result, String current, int open, int close, int pair){
        if (current.length() == pair*2){
            result.add(current);
            return;
        }
        if(open<pair) getParens(result, current + "(", open + 1, close, pair);
        if(close<open) getParens(result, current + ")", open, close + 1, pair);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        ArrayList<String> list = parens(n);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("Number of solutions: " + list.size() + "\n");
    }
}

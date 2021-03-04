package longestValidParentheses;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    static boolean validity(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(!stack.empty() && stack.peek() == '('){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.empty();
    }

    static int lvp(String s){
        int maxLen = 0;
        for(int i = 0; i<s.length(); i++){
            for(int j=i+2; j<s.length(); j+=2){
                if(validity(s.substring(i, j))){
                    maxLen  = Math.max(maxLen, j-i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter parentheses combination: ");
        String str = sc.nextLine();
        int ans = lvp(str);
        System.out.println("Longest valid parentheses for given combination is : "+ ans);
    }
}

package Leetcode;

import java.util.List;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    private static Map<Character, char[]> keyMap = new HashMap<>();
    static {
        keyMap.put('2', new char[]{'a','b','c'});
        keyMap.put('3', new char[]{'d','e','f'});
        keyMap.put('4', new char[]{'g','h','i'});
        keyMap.put('5', new char[]{'j','k','l'});
        keyMap.put('6', new char[]{'m','n','o'});
        keyMap.put('7', new char[]{'p','q','r','s'});
        keyMap.put('8', new char[]{'t','u','v'});
        keyMap.put('9', new char[]{'w','x','y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        letterCombinations(result, digits, new StringBuilder(), 0);
        return result;
    }

    public static void letterCombinations(List<String> result, String digits, StringBuilder sb, int index){
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        char[] c = keyMap.get(digits.charAt(index));
        for (char val : c) {
            sb.append(val);
            letterCombinations(result, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } 
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }
}

package CtCi.Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups {
    public static ArrayList<String> getPermutations(String s){
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildMap(s);
        getPermutations(map, "", s.length(), result);
        return result;
    }

    public static HashMap<Character, Integer> buildMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
    }

    public static void getPermutations(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if(remaining == 0) {
			result.add(prefix);
			return;
		}
        for (Character  c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
				map.put(c,  count - 1);
				getPermutations(map, prefix + c, remaining - 1, result);
				map.put(c,  count);
			}
        }
    }

    public static void main(String[] args) {
        String s = "aabbccc";
		ArrayList<String> result = getPermutations(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
    }
}

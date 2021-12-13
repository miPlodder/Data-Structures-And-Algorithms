package datastructures.string.type16;

import java.util.*;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "cd"));
        System.out.println(isAnagram("ab", "ba"));
        System.out.println(isAnagram("a", "ab"));

    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) > 1) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}

package datastructures.string.type15;

import java.util.HashMap;

//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt(""));
    }

    private static int romanToInt(String str) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        initializeMap(map);
        char prev = 'I';
        for (int i = str.length() - 1; i >= 0; i--) {
            char curr = str.charAt(i);
            if (map.get(prev) > map.get(curr)) {
                result -= map.get(curr);
            } else {
                result += map.get(curr);
            }
            prev = curr;
        }
        return result;
    }

    private static void initializeMap(HashMap<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}

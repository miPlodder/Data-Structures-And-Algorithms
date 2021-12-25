package algorithms.recursion;

import java.util.ArrayList;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombOfAPhoneNumber {

    private static String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("", "234"));
        System.out.println(letterCombinationsCount("", "234"));
    }

    public static ArrayList<String> letterCombinations(String rsf, String ros) {
        ArrayList<String> result = new ArrayList<>();
        if (rsf.isEmpty() && ros.isEmpty()) return result;
        if (ros.isEmpty()) {
            result.add(rsf);
            return result;
        }
        int digit = ros.charAt(0) - '0' - 2;
        for (char ch : keypad[digit].toCharArray()) {
            result.addAll(letterCombinations(rsf + ch, ros.substring(1)));
        }
        return result;
    }

    public static int letterCombinationsCount(String rsf, String ros) {
        int result = 0;
        if (rsf.isEmpty() && ros.isEmpty()) return result;
        if (ros.isEmpty()) {
            return ++result;
        }
        int digit = ros.charAt(0) - '0' - 2;
        for (char ch : keypad[digit].toCharArray()) {
            result += (letterCombinationsCount(rsf + ch, ros.substring(1)));
        }
        return result;
    }
}

package algorithms.recursion.level9;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(partition(str));
    }

    private static List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(str, 0, new ArrayList<>(), result);
        return result;
    }

    private static void partitionHelper(String str, int idx, List<String> osf, List<List<String>> result) {
        if (idx == str.length()) {
            result.add(new ArrayList<>(osf));
            return;
        }
        for (int i = idx; i < str.length(); i++) {
            if (isPalindrome(str, idx, i)) {
                osf.add(str.substring(idx, i + 1));
                partitionHelper(str, i + 1, osf, result);
                osf.remove(osf.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}

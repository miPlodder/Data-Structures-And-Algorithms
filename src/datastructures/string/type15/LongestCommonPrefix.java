package datastructures.string.type15;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"xflower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ababa", "a", ""}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i = 0;
        for (; i < strs[0].length(); i++) {
            char ithPrefix = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || ithPrefix != str.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
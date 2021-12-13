package datastructures.string.type15;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring("cabababb"));
        System.out.println(longestPalindromeSubstring(""));
        System.out.println(longestPalindromeSubstring("a"));
    }

    private static String longestPalindromeSubstring(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        int low, high;
        for (int i = 0; i < str.length(); i++) {
//            even logic
            low = i - 1;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (end - start + 1 < high - low + 1) {
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
//            odd logic
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (end - start + 1 < high - low + 1) {
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }
        return str.substring(start, end + 1);
    }
}

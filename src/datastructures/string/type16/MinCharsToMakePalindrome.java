package datastructures.string.type16;

//https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
public class MinCharsToMakePalindrome {

    public static void main(String[] args) {
        System.out.println(minCharsToMakePalindrome("saksham"));
        System.out.println(minCharsToMakePalindrome("AACECAAAA"));
        System.out.println(minCharsToMakePalindrome("ABCD"));
        System.out.println(minCharsToMakePalindrome("mbadm"));
        System.out.println(minCharsToMakePalindrome("leetcode"));
        System.out.println(minCharsToMakePalindrome("g"));
        System.out.println(minCharsToMakePalindrome("no"));
        System.out.println(minCharsToMakePalindrome("hqghumeaylnlfdxfi"));
    }

    private static int minCharsToMakePalindrome(String str) {
        int count = 0;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                j--;
            } else {
                str = str.charAt(j) + str;
                count++;
            }
            i++;
        }
        return count;
    }

}

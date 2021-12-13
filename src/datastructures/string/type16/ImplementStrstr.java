package datastructures.string.type16;

//https://leetcode.com/problems/implement-strstr/
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", "x"));
        System.out.println(strStr("saksham", ""));

    }

    public static int strStr(String x, String y) {
        if (y.length() == 0) return 0;
        for (int i = 0; i <= (x.length() - y.length()); i++) {
            int j = 0;
            while (j < y.length() && x.charAt(i + j) == y.charAt(j)) j++;
            if (j == y.length()) return i;
        }
        return -1;
    }

}

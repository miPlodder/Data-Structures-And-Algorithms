package datastructures.string.type15;

//https://leetcode.com/problems/repeated-string-match/
//Rabin Karp
//TODO
public class RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("ab", "ababab"));
        System.out.println(repeatedStringMatch("ab", "abababx"));
        System.out.println(repeatedStringMatch("xyz", "abc"));
        System.out.println(repeatedStringMatch("abc", "ab"));
    }

    public static int repeatedStringMatch(String a, String b) {
        int rep = 1;
        int i = 0, j = 0;
        while (i < a.length() && a.charAt(i) != b.charAt(j)) i++;
        while (j < b.length()) {
            if (a.length() == i) {
                rep++;
                a += a;
            }
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                return -1;
            }
        }
        return rep;
    }
}

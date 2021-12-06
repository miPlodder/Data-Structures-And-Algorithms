package datastructures.string.type15;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println("[" + reverseWords("  hello     world  ") + "]");
        System.out.println("[" + reverseWords("a good   example") + "]");
        System.out.println("[" + reverseWords_OptimalSolution("  hello     world  ") + "]");
        System.out.println("[" + reverseWords_OptimalSolution("a good   example") + "]");
    }

    private static String reverseWords_OptimalSolution(String s) {
        String res = "";
        int i = s.length() - 1;
        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;

            if (res.isEmpty()) {
                res = res.concat(s.substring(i + 1, j + 1));
            } else {
                res = res.concat(" " + s.substring(i + 1, j + 1));
            }
        }
        return res;
    }

    /**
     * reversing is nothing but a mirror image
     */
    private static String reverseWords(String s) {
        String result = "";
        s = s.trim();
        char[] chars = s.toCharArray();
        reverse(chars);
        for (String str : new String(chars).split(" ")) {
            if (str.trim().length() == 0) {
                continue;
            }
            char[] ch = str.toCharArray();
            reverse(ch);
            result += new String(ch);
            result += " ";
        }

        return result.trim();
    }

    private static void reverse(char[] chars) {
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

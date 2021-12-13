package datastructures.string.type16;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
    }

    private static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            String temp = "";
            int count = 1;
            result += "$";
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    temp = temp + count + result.charAt(j - 1);
                    count = 1;
                }
            }
            result = temp;
        }
        return result;
    }
}

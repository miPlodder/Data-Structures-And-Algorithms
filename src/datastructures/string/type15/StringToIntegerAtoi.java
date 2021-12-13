package datastructures.string.type15;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("-2147483644"));
        System.out.println(myAtoi("" + (Integer.MAX_VALUE - 5)));
        System.out.println(myAtoi("" + Integer.MAX_VALUE + "5"));
        System.out.println(myAtoi("" + Integer.MIN_VALUE));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("-123"));
        System.out.println(myAtoi(" -1 23"));
        System.out.println(myAtoi(" x"));
        System.out.println(myAtoi(" 12345 x"));
        System.out.println(myAtoi(" 1234567890 x"));
        System.out.println(myAtoi("1234567890987654321"));
        System.out.println(myAtoi(" -1234567890987654321"));
        System.out.println(myAtoi("12345"));
        System.out.println(myAtoi("--12345"));
        System.out.println(myAtoi("--a 12345"));

    }

    private static int myAtoi(String str) {
        int i = 0, number = 0;
        int sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i < str.length()) {
            if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (str.charAt(i) == '+') {
                i++;
            }
        }
        if (i < str.length() && !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) return number;
        while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            int curr = str.charAt(i) - '0';
            // overflow
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && curr > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            number *= 10;
            number += curr;
            i++;
        }
        return sign * number;
    }
}

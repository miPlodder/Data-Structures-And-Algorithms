package datastructures.stack.type13;

import java.util.HashSet;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static void main(String[] args) {
        String str = "[{]";
        System.out.println(isValid(str));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if ((ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{') || (ch == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

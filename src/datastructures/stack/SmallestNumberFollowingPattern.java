package datastructures.stack;

import java.util.Stack;

//https://www.youtube.com/watch?v=GOCbsY7Arw4
public class SmallestNumberFollowingPattern {

    public static void main(String[] args) {
        System.out.println(findSmallestNumberFollowingPattern("MMMM"));
        System.out.println(findSmallestNumberFollowingPattern("NNNN"));
        System.out.println(findSmallestNumberFollowingPattern("MMNMM"));
        System.out.println(findSmallestNumberFollowingPattern("NNMNN"));
    }

    private static int findSmallestNumberFollowingPattern(String input) {
        String result = "";
        Stack<Integer> stack = new Stack();
        int num = 1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'M') {
                stack.add(num);
                num++;
            } else if (ch == 'N') {
                stack.add(num);
                num++;
                while (!stack.isEmpty()) result += stack.pop();
            } else {
                return -1;
            }
        }
        result += num;
        while (!stack.isEmpty()) result += stack.pop();
        return Integer.parseInt(result);
    }
}

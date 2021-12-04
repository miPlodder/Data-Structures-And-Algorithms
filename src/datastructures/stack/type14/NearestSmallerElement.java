package datastructures.stack.type14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.interviewbit.com/problems/nearest-smaller-element/
public class NearestSmallerElement {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1));
        System.out.println(previousSmallerNumber(nums));
    }

    private static ArrayList<Integer> previousSmallerNumber(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= nums.get(i))
                stack.pop();
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.add(nums.get(i));
        }
        return result;
    }
}

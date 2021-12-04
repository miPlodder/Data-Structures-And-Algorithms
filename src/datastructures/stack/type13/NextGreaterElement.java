package datastructures.stack.type13;

import java.util.Arrays;
import java.util.Stack;
import java.util.HashMap;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement_NaiveBruteForce(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElement_OptimalSolution(nums1, nums2)));
    }

    private static int[] nextGreaterElement_NaiveBruteForce(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            boolean hasNextGreater = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    hasNextGreater = true;
                }
                if (hasNextGreater && nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    private static int[] nextGreaterElement_OptimalSolution(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

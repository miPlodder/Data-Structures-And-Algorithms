package algorithms.recursion.level9;

import java.util.*;

//https://leetcode.com/problems/subsets/
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.print(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, 0, new ArrayList<>());
    }

    private static List<List<Integer>> subsetsHelper(int[] nums, int index, List<Integer> output) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            result.add(output);
            return result;
        }
        List<Integer> left = new ArrayList<>();
        left.addAll(output);
        result.addAll(subsetsHelper(nums, index + 1, left));
        List<Integer> right = new ArrayList<>();
        right.addAll(output);
        right.add(nums[index]);
        result.addAll(subsetsHelper(nums, index + 1, right));

        return result;
    }
}

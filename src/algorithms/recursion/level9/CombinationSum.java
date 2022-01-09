package algorithms.recursion.level9;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] nums, int target, int idx, List<Integer> ros, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ros));
            return;
        }
        if (idx == nums.length || target < 0) return;

        ros.add(nums[idx]);
        combinationSumHelper(nums, target - nums[idx], idx, ros, result);
        // backtracking
        ros.remove(ros.size() - 1);
        combinationSumHelper(nums, target, idx + 1, ros, result);
    }
}

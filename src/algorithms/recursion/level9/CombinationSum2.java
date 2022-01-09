package algorithms.recursion.level9;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2};
        int target = 4;
        System.out.println(combinationSum2(nums, target));
    }

    private static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2Helper(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum2Helper(int[] nums, int target, int idx, List<Integer> ros, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ros));
            return;
        }
        if (idx == nums.length || target < 0) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            ros.add(nums[i]);
            combinationSum2Helper(nums, target - nums[i], i + 1, ros, result);
            ros.remove(ros.size() - 1);
        }
    }
}

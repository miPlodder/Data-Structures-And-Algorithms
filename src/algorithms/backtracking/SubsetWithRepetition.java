package algorithms.backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/subsets-ii/
public class SubsetWithRepetition {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        Arrays.sort(nums);
        System.out.println("Different recursive approach to all subsets: " + subsetWithRecursionApproach2(nums, 0, new ArrayList<>(), new ArrayList<>()));
        System.out.println("Recursive approach to find all subsets with no repetition: " + subsetWithRepetition(nums));
    }

    private static List<List<Integer>> subsetWithRepetition(int[] nums) {
        return subsetWithRepetitionHelper(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> subsetWithRepetitionHelper(int[] nums, int idx, List<Integer> osf, List<List<Integer>> result) {
        result.add(new ArrayList<>(osf));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i - 1] == nums[i]) continue;
            osf.add(nums[i]);
            subsetWithRepetitionHelper(nums, i + 1, osf, result);
            // this is backtracking
            osf.remove(osf.size() - 1);
        }
        return result;
    }

    /**
     * Below is a different recursive solution for finding all the possible subsets of an integer array
     */
    private static List<List<Integer>> subsetWithRecursionApproach2(int[] nums, int idx, List<Integer> osf, List<List<Integer>> result) {
        result.add(new ArrayList<>(osf));
        for (int i = idx; i < nums.length; i++) {
            osf.add(nums[i]);
            subsetWithRepetitionHelper(nums, i + 1, osf, result);
            osf.remove(osf.size() - 1);
        }
        return result;
    }
}

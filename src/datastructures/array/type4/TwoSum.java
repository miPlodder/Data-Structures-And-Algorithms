package datastructures.array.type4;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();//(nums[i], index)
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                pair[0] = map.get(target - nums[i]);
                pair[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return pair;
    }
}

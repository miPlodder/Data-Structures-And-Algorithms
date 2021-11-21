package datastructures.array.type4;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {4, 0, -2, 2, 1};
        int k = 4;
        System.out.println(subarraySum_naive(nums, k));
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum_naive(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();//(index, sum)
        int sum = 0;
        hm.put(sum, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

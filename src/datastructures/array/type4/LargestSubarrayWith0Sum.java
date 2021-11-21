package datastructures.array.type4;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-zero-sum-official/ojquestion#!
public class LargestSubarrayWith0Sum {

    public static void main(String[] args) {
//        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] nums = {0, 0, 0, 0};
//        int[] nums = {};
//        int[] nums = {2, 8, -8, -2, 1, -1};
        System.out.println(largestSubarrayWith0Sum_naiveApproach(nums));
        System.out.println(largestSubarrayWith0Sum(nums));
    }

    private static int largestSubarrayWith0Sum_naiveApproach(int[] nums) {
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
        return maxi;
    }

    private static int largestSubarrayWith0Sum(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();//(sum,index)
        int sum = 0, maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (hm.containsKey(sum)) {
                    maxi = Math.max(maxi, i - hm.get(sum));
                } else {
                    hm.put(sum, i);
                }
            }
        }
        return maxi;
    }
}

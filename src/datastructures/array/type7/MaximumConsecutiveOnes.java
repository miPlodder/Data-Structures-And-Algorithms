package datastructures.array.type7;

//https://leetcode.com/problems/max-consecutive-ones/
public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, csf = 0;
        for (int i = 0; i < nums.length; i++) {
            csf = nums[i] == 1 ? csf + 1 : 0;
            max = Math.max(csf, max);
        }
        return max;
    }
}

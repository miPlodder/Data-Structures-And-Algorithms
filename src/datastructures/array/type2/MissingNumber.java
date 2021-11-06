package datastructures.array.type2;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public static void main(String[] args) {
//        int[] nums = {3, 0, 1};
//        int[] nums = {1, 0};
        int[] nums = {};

        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index) {
                if (nums[index] == nums.length) {
                    index++;
                    continue;
                }
                swap(nums, index, nums[index]);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

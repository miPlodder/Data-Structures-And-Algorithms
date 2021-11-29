package datastructures.array.type7;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicateFromSortedArrays {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int k = 0;
        if (nums.length == 0) {
            return k;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}

package datastructures.array.type2;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
//        int[] nums = {};
//        int[] nums = {2, 3, 3};
        System.out.println(findDuplicateNumber(nums));
    }

    private static int findDuplicateNumber(int[] nums) {
        //step-1) perform a cyclic sort
        int index = 0;
        while (index < nums.length) {
            if ((nums[index] != index + 1)) {
                if (nums[index] == nums[nums[index] - 1]) {
                    index++;
                    continue;
                }
                swap(nums, nums[index] - 1, index);
            } else {
                index++;
            }
        }

        //step-2)linear search over nums, where first index where (nums[i] != i+1)
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicate = nums[i];
            }
        }
        return duplicate;
    }

    private static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }

}

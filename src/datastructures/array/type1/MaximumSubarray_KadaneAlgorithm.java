package datastructures.array.type1;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray_KadaneAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//      int[] arr = {-1,9};
        System.out.println(kandaneAlgorithm(arr));
    }

    private static int kandaneAlgorithm(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // ensure we are not adding -ve value to a subarray
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}

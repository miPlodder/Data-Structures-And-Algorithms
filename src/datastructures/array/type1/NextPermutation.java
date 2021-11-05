package datastructures.array.type1;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {

    public static void main(String[] args) {
//        int[] arr = {2,3,1}
//        int[] arr = {3, 2, 1};
        int[] arr = {1};

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextPermutation(int[] arr) {
        // step-1) find the (i) and (i-1) index where arr[i-1] < a[i-1] from the backwards
        int index = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                index = i - 1;
                break;
            }
        }
        // optional, if last permutation sequence, then just reverse the array
        if (index == -1) {
            int start = 0, end = arr.length - 1;
            while (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
            return;
        }

        // step-2) find the index where value is greater than "index" from the backwards
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[index] < arr[i]) {
                swap(arr, i, index);
                break;
            }
        }
        int start = index + 1;
        int end = arr.length - 1;
        // step-3) reverse the array from start to end
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int f, int e) {
        int temp = arr[f];
        arr[f] = arr[e];
        arr[e] = temp;
    }
}
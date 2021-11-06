package datastructures.array.type2;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int m = 1;
        int[] nums2 = {1, 2, 3, 5, 6};
        int n = 5;

        mergeSortedArray(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    private static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length) {
            if (nums1[ptr1] <= nums2[ptr2]) {

            } else {
                int temp = nums1[ptr1];
                nums1[ptr1] = nums2[ptr2];
                nums2[ptr2] = temp;
                Arrays.sort(nums2);
            }
            ptr1++;
        }

    }

    private static void mergeSortedArray2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums1.length == m) {
            return;
        }

        for (int i = 0; i < m; i++) {
            swap(nums1, i, i + m);
        }
        int ptr1 = m, ptr2 = 0, index = 0;
        //step1) merging 2 sorted arrays
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[index] = nums2[ptr2];
                ptr2++;
            } else {
                nums1[index] = nums1[ptr1];
                ptr1++;
            }
            index++;
        }
        //step2) appending nums1 array
        while (ptr1 < nums1.length) {
            nums1[index] = nums1[ptr1];
            ptr1++;
            index++;
        }
        //step3) appending nums2 array
        while (ptr2 < nums2.length) {
            nums1[index] = nums2[ptr2];
            ptr2++;
            index++;
        }
    }

    private static void swap(int[] num, int s, int f) {
        int temp = num[s];
        num[s] = num[f];
        num[f] = temp;
    }
}

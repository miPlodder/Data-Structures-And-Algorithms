package algorithms.divideAndConquer;

import java.util.Arrays;

/**
 * Main idea is to move the pivot element to the correct index
 * Hence, left side will be lesser than the pivot element
 * and right side will be more than the pivot element
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int s = start;
        int e = end;
        int mid = (s + e) / 2;
        int pivot = arr[mid];
        while (s <= e) {
            // below 2 while are the reason why for sorted array, no swapping takes place
            // for left side array
            while (arr[s] < pivot) s++;
            // for right side array
            while (arr[e] > pivot) e--;

            while (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // pivot is at the correct index
        // sort the left and the right part
        sort(arr, start, e);
        sort(arr, s, end);
    }
}

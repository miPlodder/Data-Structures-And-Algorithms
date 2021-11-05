package array;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
public class SortColors {

    public static void main(String[] args) {
//        int[] arr = {2, 0, 2, 1, 1, 0};
//        int[] arr = {2, 1, 0};
//        int[] arr = {};
        int[] arr = {2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortColors(int[] arr) {
        int low = -1;
        int mid = 0;
        int high = arr.length;

        while (mid < high) {
            switch (arr[mid]) {
                case 0:
                    low++;
                    swap(arr, low, mid);
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    high--;
                    swap(arr, high, mid);
                    break;
            }
        }
    }

    private static void swap(int[] arr, int f, int e) {
        int temp = arr[f];
        arr[f] = arr[e];
        arr[e] = temp;
    }
}

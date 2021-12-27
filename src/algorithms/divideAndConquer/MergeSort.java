package algorithms.divideAndConquer;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 7, 8, 9, 2, 2};
        System.out.println(Arrays.toString(mergeSort1(arr)));
        System.out.println(Arrays.toString(mergeSort2(arr, 0, arr.length - 1)));
        mergeSort_inPlace(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort1(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort1(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort1(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] mergeSort2(int[] arr, int start, int end) {
        if (start == end) return new int[]{arr[start]};

        int mid = (end + start) / 2;
        int[] left = mergeSort2(arr, start, mid);
        int[] right = mergeSort2(arr, mid + 1, end);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    private static void mergeSort_inPlace(int[] arr, int start, int end) {
        if (start == end) return;

        int mid = (end + start) / 2;
        mergeSort_inPlace(arr, start, mid);
        mergeSort_inPlace(arr, mid + 1, end);

        merge_inPlace(arr, start, mid, end);
    }

    private static void merge_inPlace(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            result[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < result.length; l++) arr[start + l] = result[l];
    }

}

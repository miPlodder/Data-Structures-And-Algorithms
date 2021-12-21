package algorithms.recursion;

import java.util.Arrays;

public class BasicQuestions2 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
//        bubbleSortRecursive(arr, arr.length - 1, 0);
        selectionSortRecursive(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void selectionSortIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++)
                if (arr[i] > arr[j])
                    swap(arr, i, j);
    }

    private static void selectionSortRecursive(int[] arr, int i, int j) {
        if (i == arr.length) return;

        if (j < arr.length) {
            if (arr[i] > arr[j]) {
                swap(arr, i, j);
            }
            selectionSortRecursive(arr, i, j + 1);
        } else {
            selectionSortRecursive(arr, i + 1, i + 1);
        }
    }

    private static void bubbleSortIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    private static void bubbleSortRecursive(int[] arr, int i, int j) {
        if (i == 0) return;
        if (i > j) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            bubbleSortRecursive(arr, i, j + 1);
        } else {
            bubbleSortRecursive(arr, i - 1, 0);
        }
    }

}

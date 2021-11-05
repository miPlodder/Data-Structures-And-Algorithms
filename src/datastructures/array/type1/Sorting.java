package datastructures.array.type1;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1, 6, 9, 8};
//        int[] arr = {};
//        int[] arr = {1};
//        int[] arr = {2,1};
//        int[] arr = {-1, -4, 0, 3, 5, -2};
        int[] arr = {5, 3, 2, 4, 1};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        cyclicSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /*
     * For array with elements ranging from 1 to N
     *
     */
    private static void cyclicSort(int[] arr) {

        for (int i = 0; i < arr.length; ) {
            if (arr[i] != (i + 1)) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}

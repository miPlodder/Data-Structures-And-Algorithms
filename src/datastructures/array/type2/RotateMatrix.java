package datastructures.array.type2;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/
public class RotateMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {};
        int[][] matrix = {{1, 2}, {3, 4}};

        rotateMatrix(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void rotateMatrix(int[][] matrix) {
        //step-1) do a transpose of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //step-2) reverse each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[0].length - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

}

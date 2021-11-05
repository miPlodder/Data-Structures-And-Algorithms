package array;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix = {};
//        int[][] matrix = {{1}};
//        int[][] matrix = {{0, 1}};
        setZeroes1(matrix);
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }

    // Time complexity = n^m
    // Space complexity = n+m
    private static void setZeroes1(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int[] m = new int[matrix.length];
        int[] n = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = 1;
                    n[j] = 1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            if (m[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}

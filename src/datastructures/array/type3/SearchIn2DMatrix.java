package datastructures.array.type3;

//https://leetcode.com/problems/search-a-2d-matrix/
/*
 * When ever you wanna Search, do it via Binary Search
 * Prefer Linear Search for Brute Force Approach only
 * */
public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(searchIn2DMatrix(matrix, 10));
        System.out.println(searchIn2DMatrix2(matrix, -10));
    }

    /*
     * Algo to reduce the search space either by 1 col or 1 row
     * */
    private static boolean searchIn2DMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }

    /*
     * Binary Search in a 2D matrix by virtually flattening 2D array in 1D array
     * */
    private static boolean searchIn2DMatrix2(int[][] matrix, int target) {
        int low = 0, high = (matrix.length * matrix[0].length) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}

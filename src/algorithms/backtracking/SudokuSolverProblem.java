package algorithms.backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolverProblem {

    public static void main(String[] args) {
        System.out.println((int) ('1' - '0'));
        System.out.println((char) (1 + '0'));
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(sudokuSolver(board));
        display(board);
    }

    private static boolean sudokuSolver(int[][] board) {

        // this is how we are replacing row, col from arguments
        // by parsing the complete board
        int r = -1, c = -1;
        boolean hasEmptyCell = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    hasEmptyCell = true;
                    break;
                }
            }
            if (hasEmptyCell) break;
        }
        // sudoku is solved and +ve base case
        if (!hasEmptyCell) return true;

        for (int i = 1; i <= board.length; i++) {
            if (isSafe(board, r, c, i)) {
                board[r][c] = i;
                if (sudokuSolver(board)) return true;
                // this is backtracking
                board[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int r, int c, int num) {
        // col
        for (int i = 0; i < board[0].length; i++)
            if (board[r][i] == num) return false;
        // row
        for (int[] item : board)
            if (item[c] == num) return false;
        // in nxn cell
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = r - r % sqrt;
        int startCol = c - c % sqrt;
        for (int i = startRow; i < startRow + sqrt; i++)
            for (int j = startCol; j < startCol + sqrt; j++)
                if (board[i][j] == num)
                    return false;
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
    }

}

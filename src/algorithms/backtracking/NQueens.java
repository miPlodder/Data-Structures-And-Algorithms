package algorithms.backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/n-queens/
public class NQueens {

    public static void main(String[] args) {
        System.out.print(nQueens(0, new boolean[4][4]));
    }

    private static int nQueens(int r, boolean[][] hasVisited) {
        int result = 0;
        if (r == hasVisited.length) {
            display(hasVisited);
            return 1;
        }
        for (int col = 0; col < hasVisited[0].length; col++) {
            if (isSafe(r, col, hasVisited)) {
                hasVisited[r][col] = true;
                result += nQueens(r + 1, hasVisited);
                hasVisited[r][col] = false;
            }
        }
        return result;
    }

    private static void display(boolean[][] hasVisited) {
        for (boolean[] row : hasVisited) {
            for (boolean cell : row) {
                if (cell)
                    System.out.print("Q");
                else
                    System.out.print(".");
            }
        }
        System.out.println();
    }

    private static boolean isSafe(int r, int c, boolean[][] hasVisited) {
        // up in the same column
        for (int i = r - 1; i >= 0; i--)
            if (hasVisited[i][c]) return false;
        // left diagonal
        for (int i = 1; i <= Math.min(r, c); i++)
            if (hasVisited[r - i][c - i]) return false;
        // right diagonal
        for (int i = 1; i <= Math.min(r, hasVisited[0].length - 1 - c); i++)
            if (hasVisited[r - i][c + i]) return false;
        return true;
    }
}

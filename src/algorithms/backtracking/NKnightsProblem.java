package algorithms.backtracking;

public class NKnightsProblem {

    public static void main(String[] args) {
        System.out.println(nKnightsProblem(0, 0, new boolean[4][4], 6));

    }

    private static int nKnightsProblem(int r, int c, boolean[][] board, int target) {
        int result = 0;
        if (target == 0) {
            display(board);
            System.out.println();
            return ++result;
        }
        if (r == board.length - 1 && c == board[0].length)
            return result;

        if (c == board[0].length) {
            result += nKnightsProblem(r + 1, 0, board, target);
            return result;
        }

        if (isSafe(r, c + 1, board) && isValid(r, c + 1, board)) {
            board[r][c + 1] = true;
            result += nKnightsProblem(r, c + 1, board, target - 1);
            board[r][c + 1] = false;
        }
        result += nKnightsProblem(r, c + 1, board, target);
        return result;
    }

    private static boolean isSafe(int r, int c, boolean[][] board) {
        if (isValid(r - 1, c - 2, board))
            if (board[r - 1][c - 2])
                return false;
        if (isValid(r - 1, c + 2, board))
            if (board[r - 1][c + 2])
                return false;
        if (isValid(r - 2, c - 1, board))
            if (board[r - 2][c - 1])
                return false;
        if (isValid(r - 2, c + 1, board))
            if (board[r - 2][c + 1])
                return false;
        return true;
    }

    private static boolean isValid(int r, int c, boolean[][] board) {
//        underflow
        if (r < 0 || c < 0) return false;
//        overflow
        if (r >= board.length || c >= board[0].length) return false;
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                if (cell) System.out.print("K");
                else System.out.print(".");
            }
            System.out.println();
        }
    }
}

package algorithms.backtracking;

import java.util.List;
import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {

    public static void main(String[] args) {
        int n = 4;
        int[][] m =
                {
                        {1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}
                };

        System.out.println(findPath(m, n));
    }

    private static List<String> findPath(int[][] m, int n) {
        List<String> result = new ArrayList<>();
        if (m[0][0] == 0) {
            return result;
        }
        m[0][0] = 0;
        findPathHelper(m, 0, 0, "", result);
        m[0][0] = 1;
        return result;
    }

    private static void findPathHelper(int[][] m, int r, int c, String psf, List<String> result) {
        if (r == m.length - 1 && c == m[0].length - 1) {
            result.add(psf);
            return;
        }
        // up
        if (isSafe(m, r - 1, c)) {
            m[r - 1][c] = 0;
            findPathHelper(m, r - 1, c, psf + "U", result);
            m[r - 1][c] = 1;
        }
        //down
        if (isSafe(m, r + 1, c)) {
            m[r + 1][c] = 0;
            findPathHelper(m, r + 1, c, psf + "D", result);
            m[r + 1][c] = 1;
        }
        //left
        if (isSafe(m, r, c - 1)) {
            m[r][c - 1] = 0;
            findPathHelper(m, r, c - 1, psf + "L", result);
            m[r][c - 1] = 1;
        }
        //right
        if (isSafe(m, r, c + 1)) {
            m[r][c + 1] = 0;
            findPathHelper(m, r, c + 1, psf + "R", result);
            m[r][c + 1] = 1;
        }

    }

    private static boolean isSafe(int[][] m, int r, int c) {
        // overflow condn
        if (r >= m.length || c >= m[0].length) return false;
        //underflow condn
        if (r < 0 || c < 0) return false;
        // already covered
        if (m[r][c] == 0) return false;
        return true;
    }

}

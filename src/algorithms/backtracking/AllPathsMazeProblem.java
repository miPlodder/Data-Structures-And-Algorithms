package algorithms.backtracking;

import java.util.Arrays;

public class AllPathsMazeProblem {

    public static void main(String[] args) {
        printAllPaths(0, 0, "", new boolean[3][3]);
        System.out.println();
        printAllPaths2(0, 0, "", new boolean[3][3], new int[3][3], 1);

    }

    private static void printAllPaths(int r, int c, String rsf, boolean[][] isVisited) {
        if (r == isVisited.length - 1 && c == isVisited.length - 1) {
            System.out.print(rsf + ", ");
            return;
        }

        if (isVisited[r][c]) return;
        else isVisited[r][c] = true;
//        overflow condn
        if (c < isVisited[0].length - 1) printAllPaths(r, c + 1, rsf + "R", isVisited);
        if (r < isVisited.length - 1) printAllPaths(r + 1, c, rsf + "D", isVisited);
//          underflow condn
        if (c > 0) printAllPaths(r, c - 1, rsf + "L", isVisited);
        if (r > 0) printAllPaths(r - 1, c, rsf + "U", isVisited);

        isVisited[r][c] = false;
    }

    private static void printAllPaths2(int r, int c, String rsf, boolean[][] isVisited, int[][] paths, int steps) {
        if (r == isVisited.length - 1 && c == isVisited.length - 1) {
            paths[r][c] = steps;
            for (int[] path : paths)
                System.out.println(Arrays.toString(path));
            System.out.println(rsf);
            paths[r][c] = 0;
            return;
        }

        // making changes
        if (isVisited[r][c]) return;
        else {
            paths[r][c] = steps;
            isVisited[r][c] = true;
        }

        //        overflow condn
        if (c < isVisited[0].length - 1) printAllPaths2(r, c + 1, rsf + "R", isVisited, paths, steps + 1);
        if (r < isVisited.length - 1) printAllPaths2(r + 1, c, rsf + "D", isVisited, paths, steps + 1);
        //        underflow condn
        if (c > 0) printAllPaths2(r, c - 1, rsf + "L", isVisited, paths, steps + 1);
        if (r > 0) printAllPaths2(r - 1, c, rsf + "U", isVisited, paths, steps + 1);

        // reverting changes
        isVisited[r][c] = false;
        paths[r][c] = 0;
    }
}

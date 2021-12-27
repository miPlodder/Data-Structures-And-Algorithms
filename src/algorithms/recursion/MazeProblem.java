package algorithms.recursion;

import java.util.ArrayList;

/**
 * It's a recursion problem, not a backtracking problem
 */
public class MazeProblem {

    public static void main(String[] args) {
        System.out.println(countMazeProblem(3, 3));
        mazeProblemHorAndVer(3, 3, "");
        System.out.println();
        System.out.println(mazeProblemHorVertAndDiag(3, 3, ""));
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        mazeProblemHorAndVerWithRestriction(maze, 0, 0, "");
        System.out.println();
    }

    private static int countMazeProblem(int r, int c) {
        int result = 0;
        if (r == 1 || c == 1) return ++result;
        result += countMazeProblem(r - 1, c);
        result += countMazeProblem(r, c - 1);
        return result;
    }

    private static void mazeProblemHorAndVer(int r, int c, String rsf) {
        if (r == 1 && c == 1) {
            System.out.print(rsf + ",");
            return;
        }
        if (r > 1) mazeProblemHorAndVer(r - 1, c, rsf + "V");
        if (c > 1) mazeProblemHorAndVer(r, c - 1, rsf + "H");
    }

    private static ArrayList<String> mazeProblemHorVertAndDiag(int r, int c, String rsf) {
        ArrayList<String> result = new ArrayList<>();
        if (r == 1 && c == 1) {
            result.add(rsf);
            return result;
        }
        if (r > 1) result.addAll(mazeProblemHorVertAndDiag(r - 1, c, rsf + "V"));
        if (c > 1) result.addAll(mazeProblemHorVertAndDiag(r, c - 1, rsf + "H"));
        if (c > 1 && r > 1) result.addAll(mazeProblemHorVertAndDiag(r - 1, c - 1, rsf + "D"));
        return result;
    }

    private static void mazeProblemHorAndVerWithRestriction(boolean[][] maze, int r, int c, String rsf) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(rsf + ",");
            return;
        }
        if (!maze[r][c]) return;
        if (r < maze.length - 1) mazeProblemHorAndVerWithRestriction(maze, r + 1, c, rsf + "V");
        if (c < maze[0].length - 1) mazeProblemHorAndVerWithRestriction(maze, r, c + 1, rsf + "H");
    }


}

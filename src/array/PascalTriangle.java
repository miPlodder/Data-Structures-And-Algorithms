package array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    
    public static void main(String[] args) {
//        int numRows = 4;
//        int numRows = 0;
//        int numRows = 1;
        int numRows = 7;
        List<List<Integer>> pascalTriangle = generatePascalTriangle1(numRows);
        for (List<Integer> array : pascalTriangle) {
            System.out.println(array);
        }
    }

    // Space Complexity = 1
    // Time Complexity = numRows^rumRows
    private static List<List<Integer>> generatePascalTriangle1(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (i == 0 || j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                int left = 0, right = 0;
                if (j - 1 >= 0) {
                    left = pascalTriangle.get(i - 1).get(j - 1);
                }
                if (j < i) {
                    right = pascalTriangle.get(i - 1).get(j);
                }
                row.add(left + right);
            }
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}

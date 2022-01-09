package algorithms.recursion.level9;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/permutations/
public class Permutation {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(permutation(n));
    }

    private static List<String> permutation(int n) {
        List<String> result = new ArrayList<>();
        permutationHelper(n, 1, "", result);
        return result;
    }

    private static void permutationHelper(int n, int val, String rsf, List<String> result) {
        if (val == n + 1) {
            result.add(rsf);
            return;
        }

        for (int i = 0; i <= rsf.length(); i++) {
            permutationHelper(n, val + 1, rsf.substring(0, i) + val + rsf.substring(i), result);
        }
    }
}

package algorithms.recursion.level9;

import java.util.List;
import java.util.ArrayList;

/**
 * The best thing about this problem is that it looks like a recursive problem of Permutation,
 * but it can be solved in single iteration
 */
//https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(permutationSequence(n, k));
    }

    /**
     * Modulus operation is 0-indexed
     */
    private static String permutationSequence(int n, int k) {
        String result = "";
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        // 0-indexed
        k--;
        for (int i = 0; i < n; i++) {
            fact *= (i + 1);
            list.add(i + 1);
        }
        while (!list.isEmpty()) {
            fact /= list.size();
            result += list.get(k / fact);
            list.remove(k / fact);
            k %= fact;

        }
        return result;
    }
}

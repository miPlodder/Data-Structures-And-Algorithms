package algorithms.recursion;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NumberDiceRollsWithTargetSum {

    public static void main(String[] args) {
        System.out.println(numberOfDiceRollsWithTargetSum(30, 30, 500));
    }

    private static int numberOfDiceRollsWithTargetSum(int n, int k, int target) {
        int result = 0;
        if (target == 0) return ++result;
        else if (target < 0) return result;

        if (n == 0) return result;

        for (int i = 1; i <= k; i++) result += numberOfDiceRollsWithTargetSum(n - 1, k, target - i);
        return result;
    }

    private static int numberOfDiceRollsWithTargetSum_dp(int n, int k, int target) {
        int result = 0;

        return result;
    }

}

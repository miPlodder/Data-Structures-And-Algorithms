package datastructures.array.type3;

//https://leetcode.com/problems/powx-n/
public class Power {

    public static void main(String[] args) {
        double x = 2;
        int n = 6;
        System.out.println(pow(x, n));
    }

    private static double pow(double x, int n) {
        double ans = 1, X = x;
        long N = n;
        if (N < 0) {
            N = -N;
        }
        while (N > 0) {
            if (N % 2 != 0) {
                ans *= X;
                N -= 1;
            } else {
                X *= X;
                N /= 2;
            }
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}

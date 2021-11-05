package array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {};
//        int[] arr = {7, 6, 5, 4};
        int[] arr = {100, 50, 1, 99};
        System.out.println(bestTimeToBuyAndSellStock(arr));
    }

    private static int bestTimeToBuyAndSellStock(int[] arr) {
        int maxProfit = 0;
        if (arr.length == 0) {
            return maxProfit;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return maxProfit;
    }
}

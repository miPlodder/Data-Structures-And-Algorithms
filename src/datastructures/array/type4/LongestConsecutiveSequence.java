package datastructures.array.type4;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 100, 102, 101};
        System.out.println(longestConsSubSeq(nums));
    }

    private static int longestConsSubSeq(int[] nums) {
        int maxi = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int max = 1, counter = num + 1;
                while (hs.contains(counter)) {
                    max++;
                    counter++;
                }
                maxi = Math.max(max, maxi);
            }
        }
        return maxi;
    }

}

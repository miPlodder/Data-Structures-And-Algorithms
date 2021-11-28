package datastructures.array.type7;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {1, 2, -2, -1};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        for (List<Integer> triplet : triplets) {
            System.out.print(triplet.toString() + " , ");
        }
        System.out.println();
        triplets = threeSum2(nums);
        for (List<Integer> triplet : triplets) {
            System.out.print(triplet.toString() + " , ");
        }

    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();//(num, count)
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int num : nums) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }
        for (int i = 0; i < nums.length - 2; i++) {
            hm.put(nums[i], hm.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length - 1; j++) {
                hm.put(nums[j], hm.get(nums[j]) - 1);
                int sum = -nums[i] - nums[j];
                if (hm.containsKey(sum) && hm.get(sum) != 0) {
                    List<Integer> triplet = Arrays.asList(sum, nums[i], nums[j]);
                    Collections.sort(triplet);
                    set.add(triplet);
                }
                hm.put(nums[j], hm.get(nums[j]) + 1);
            }
            hm.put(nums[i], hm.get(nums[i]) + 1);
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            triplets.add((List<Integer>) iterator.next());
        }
        return triplets;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
//            2 pointer technique
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        hi--;
                        lo++;
                    } else if (sum > 0) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return triplets;
    }
}

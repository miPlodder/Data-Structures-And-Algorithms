package datastructures.array.type2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
public class MergeOverlappingInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {0, 4}};
//        int[][] intervals = {};
//        int[][] intervals = {{1, 2}};
//        int[][] intervals = {{1, 4}, {0, 4}, {5, 6}, {1, 2}};
//        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] intervals = {{1, 4}, {0, 0}};

        int[][] mergedIntervals = merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    private static int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return mergedIntervals.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) ->
                a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (end >= i[0]) {
                end = Math.max(i[1], end);
            } else {
                mergedIntervals.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(new int[0][]);
    }

}

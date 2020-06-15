
/*
https://leetcode.com/problems/insert-interval/
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

    static int compare(int[] existing, int in) {
        if (in >= existing[0]) {
            if (in <= existing[1]) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    static public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> resList = new LinkedList<int[]>();
        int[][] tt = new int[][]{};
        boolean newIntervalInserted = false;

        if (intervals == null || intervals.length == 0) {
            resList.add(newInterval);
            return resList.toArray(tt);
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        int s = newInterval[0];
        int e = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            // compare start 's'
            int cS = compare(current, s);
            int cE = compare(current, e);
            if (cS > 0) {
                /* out of range */
                resList.add(current);
            } else if (cS < 0) {
                // Bellow
                if (cE < 0) {
                    //  bellow out of range
                    if (!newIntervalInserted) {
                        resList.add(newInterval);
                        newIntervalInserted = true;
                    }
                    resList.add(current);
                } else if (cE == 0) {
                    // merge and next
                    newIntervalInserted = true;
                    resList.add(new int[] { s, current[1] });
                } else {
                    // continue merge
                    continue;
                }
            } else {
                // in range
                s = current[0];
                newInterval[0] = s;
                if (cE < 0) {
                    // not possible
                } else if (cE == 0) {
                    // both in range so desolve new one(ignore it)
                    newIntervalInserted = true;
                    resList.add(current);
                } else {
                    // merge continue
                    continue;
                }
            }
        }

        // new element beyond current highest
        int[] last = intervals[intervals.length - 1];
        int cE = compare(last, e);
        if (cE > 0) {
            resList.add(newInterval);
        }

        return resList.toArray(tt);
    }

    public static void main(String[] args) {

        System.out.println("Test case 1:");
        int[][] intervals = new int[][] { { 1, 3 }, { 6, 9 } };
        int[] newInterval = new int[] { 2, 5 };
        int[][] res = insert(intervals, newInterval);
        Arrays.stream(res).forEach(x -> System.out.printf("[%d, %d],", x[0], x[1]));

        System.out.println("\nTest case 2:");
        int[][] intervals1 = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1 = new int[]{4,8};
        int[][] resp1 = insert(intervals1, newInterval1);
        Arrays.stream(resp1).forEach(interval -> System.out.printf("[%d, %d]", interval[0], interval[1]));
    }
}

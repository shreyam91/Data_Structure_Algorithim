// Question: Non-overlapping Intervals... 
// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Examples:
// Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
// Output: 1


package shreyam.GFG160;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int minRemoval(int[][] intervals) {
        int deleteCount = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                deleteCount++;
                prev = Math.min(prev, intervals[i][1]);
            } else {
                prev = intervals[i][1];
            }
        }

        return deleteCount;
    }
    public static void main(String[] args) {
        int[][] intervals = { {1, 2}, {2, 3}, {3, 4}, {1, 3} };
        int res = minRemoval(intervals);
        System.out.println(res);
    }
}

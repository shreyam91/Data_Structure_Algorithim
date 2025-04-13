// Question: Insert Interval... 
// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Examples:
// Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
// Output: [[1,3], [4,7], [8,10]]
// Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].



package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval); 

        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {4, 5}, {6, 7}, {8, 10} };
        int[] newInterval = {5, 6};

        ArrayList<int[]> result = insertInterval(intervals, newInterval);

        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

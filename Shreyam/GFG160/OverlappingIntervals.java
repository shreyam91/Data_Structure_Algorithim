// Question: Overlapping Intervals... 
// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

// Examples:
// Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
// Output: [[1,4], [6,8], [9,10]]

package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {
    public List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> ans = new ArrayList<>();

        if (arr == null || arr.length == 0) return ans;

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ans.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = ans.get(ans.size() - 1);
            if (last[1] >= arr[i][0]) {
                last[1] = Math.max(last[1], arr[i][1]);
            } else {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        OverlappingIntervals solution = new OverlappingIntervals();
        List<int[]> merged = solution.mergeOverlap(arr);

        // Print result
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

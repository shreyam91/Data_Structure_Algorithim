// Question: Maximum Number of Events That Can Be Attended II

// You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.
// You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.
// Return the maximum sum of values that you can receive by attending events.

// Example 1:
// Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
// Output: 7

package shreyam.leetCode;

import java.util.Arrays;

public class Question1751 {
    private static int[][] mem;
    private static int[] nextEvent;
    private static int n;

    private static int attendEvent(int[][] events, int pos, int k) {
        if (k == 0 || pos >= n) {
            return 0;
        }
        if (mem[pos][k] != -1) {
            return mem[pos][k];
        }

        int skipEvent = attendEvent(events, pos + 1, k);

        int next = nextEvent[pos];
        int attendEventVal = attendEvent(events, next, k - 1) + events[pos][2];
        return mem[pos][k] = Math.max(skipEvent, attendEventVal);
    }

    public static int maxValue(int[][] events, int k) {
        n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        mem = new int[n][k + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        nextEvent = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] > events[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            nextEvent[i] = left;
        }

        return attendEvent(events, 0, k);
    }
    public static void main(String[] args) {
        int events[][] = {{1,2,4},{3,4,3},{2,3,1}};
        int k = 2;
        System.out.println(maxValue(events, k));
    }
}

// Question: Reschedule Meetings for Maximum Free Time I

// You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.
// You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].
// You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest continuous period of free time during the event.
// The relative order of all the meetings should stay the same and they should remain non-overlapping.
// Return the maximum amount of free time possible after rearranging the meetings.
// Note that the meetings can not be rescheduled to a time outside the event.

// Example 1:
// Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
// Output: 2

package shreyam.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question3439 {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        if (eventTime > endTime[endTime.length - 1]) {
            int[] newStartTime = new int[startTime.length + 1];
            int[] newEndTime = new int[endTime.length + 1];
            System.arraycopy(startTime, 0, newStartTime, 0, startTime.length);
            System.arraycopy(endTime, 0, newEndTime, 0, endTime.length);
            newStartTime[startTime.length] = eventTime;
            newEndTime[endTime.length] = eventTime;
            startTime = newStartTime;
            endTime = newEndTime;
        }
        
        int n = startTime.length;
        int max_sum = 0;
        int win_sum = 0;
        int pos = 0;
        int last_end = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        while (pos < n) {
            win_sum += (startTime[pos] - last_end);
            dq.addLast(startTime[pos] - last_end);
            max_sum = Math.max(max_sum, win_sum);
            if (dq.size() > k) {
                win_sum -= dq.removeFirst();
            }
            last_end = endTime[pos];
            pos++;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int[] startTime = {1,3}, endTime = {2,5};
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
}

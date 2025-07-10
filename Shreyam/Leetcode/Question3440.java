// Question: Reschedule Meetings for Maximum Free Time II

// You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.
// These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].
// You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.
// Return the maximum amount of free time possible after rearranging the meetings.
// Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.
// Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.

// Example 1:
// Input: eventTime = 5, startTime = [1,3], endTime = [2,5]
// Output: 2

package shreyam.leetCode;

public class Question3440 {
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
    final int n = startTime.length;
    final int[] gaps = getGaps(eventTime, startTime, endTime);
    int ans = 0;
    int[] maxLeft = new int[n + 1];  // maxLeft[i] := max(gaps[0..i])
    int[] maxRight = new int[n + 1]; // maxRight[i] := max(gaps[i..n])

    maxLeft[0] = gaps[0];
    maxRight[n] = gaps[n];

    for (int i = 1; i < n + 1; ++i)
      maxLeft[i] = Math.max(gaps[i], maxLeft[i - 1]);

    for (int i = n - 1; i >= 0; --i)
      maxRight[i] = Math.max(gaps[i], maxRight[i + 1]);

    for (int i = 0; i < n; ++i) {
      final int currMeetingTime = endTime[i] - startTime[i];
      final int adjacentGapsSum = gaps[i] + gaps[i + 1];
      final boolean canMoveMeeting =
          currMeetingTime <= Math.max(i > 0 ? maxLeft[i - 1] : 0, //
                                      i + 2 < n + 1 ? maxRight[i + 2] : 0);
      ans = Math.max(ans, adjacentGapsSum + (canMoveMeeting ? currMeetingTime : 0));
    }

    return ans;
  }

  private static int[] getGaps(int eventTime, int[] startTime, int[] endTime) {
    int[] gaps = new int[startTime.length + 1];
    gaps[0] = startTime[0];
    for (int i = 1; i < startTime.length; ++i)
      gaps[i] = startTime[i] - endTime[i - 1];
    gaps[startTime.length] = eventTime - endTime[endTime.length - 1];
    return gaps;
  }
    public static void main(String[] args) {
       int eventTime = 5;
       int[] startTime = {1,3}, endTime = {2,5};
       System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }
}

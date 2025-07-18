// Question: Minimum Difference in Sums After Removal of Elements

// You are given a 0-indexed integer array nums consisting of 3 * n elements.
// You are allowed to remove any subsequence of elements of size exactly n from nums. The remaining 2 * n elements will be divided into two equal parts:
// The first n elements belonging to the first part and their sum is sumfirst.
// The next n elements belonging to the second part and their sum is sumsecond.
// The difference in sums of the two parts is denoted as sumfirst - sumsecond.
// For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
// Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.
// Return the minimum difference possible between the sums of the two parts after the removal of n elements.

// Example 1:
// Input: nums = [3,1,2]
// Output: -1

package shreyam.leetCode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question2163 {
    public static long minimumDifference(int[] nums) {
        final int n = nums.length / 3;
    long ans = Long.MAX_VALUE;
    long leftSum = 0;
    long rightSum = 0;
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>();
    long[] minLeftSum = new long[nums.length];

    for (int i = 0; i < 2 * n; ++i) {
      maxHeap.offer(nums[i]);
      leftSum += nums[i];
      if (maxHeap.size() == n + 1)
        leftSum -= maxHeap.poll();
      if (maxHeap.size() == n)
        minLeftSum[i] = leftSum;
    }

    for (int i = nums.length - 1; i >= n; --i) {
      minHeap.offer(nums[i]);
      rightSum += nums[i];
      if (minHeap.size() == n + 1)
        rightSum -= minHeap.poll();
      if (minHeap.size() == n)
        ans = Math.min(ans, minLeftSum[i - 1] - rightSum);
    }

    return ans;
    }
    public static void main(String[] args) {
        int [] nums = {3,1,2};
        System.out.println(minimumDifference(nums));
    }
}

// Question: Maximum Number of Tasks You Can Assign...
// You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks, with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed integer array workers, with the jth worker having workers[j] strength. Each worker can only be assigned to a single task and must have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).
// Additionally, you have pills magical pills that will increase a worker's strength by strength. You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.
// Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, return the maximum number of tasks that can be completed.

// Example 1:
// Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
// Output: 3

package shreyam.leetCode;

import java.util.Arrays;
import java.util.TreeMap;

public class Question2071{
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    int ans = 0;
    int l = 0;
    int r = Math.min(tasks.length, workers.length);

    Arrays.sort(tasks);
    Arrays.sort(workers);

    while (l <= r) {
      final int m = (l + r) / 2;
      if (canComplete(tasks, workers, pills, strength, m)) {
        ans = m;
        l = m + 1;

      } else {
        r = m - 1;
      }
    }

    return ans;
  }

  private static boolean canComplete(int[] tasks, int[] workers, int pillsLeft, int strength, int k) {
    TreeMap<Integer, Integer> sortedWorkers = new TreeMap<>();
    for (int i = workers.length - k; i < workers.length; ++i)
      sortedWorkers.merge(workers[i], 1, Integer::sum);

    for (int i = k - 1; i >= 0; --i) {
      Integer lo = sortedWorkers.ceilingKey(tasks[i]);
      if (lo != null) {
        sortedWorkers.merge(lo, -1, Integer::sum);
        if (sortedWorkers.get(lo) == 0) {
          sortedWorkers.remove(lo);
        }
      } else if (pillsLeft > 0) {
        lo = sortedWorkers.ceilingKey(tasks[i] - strength);
        if (lo != null) {
          sortedWorkers.merge(lo, -1, Integer::sum);
          if (sortedWorkers.get(lo) == 0) {
            sortedWorkers.remove(lo);
          }
          --pillsLeft;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }

    return true;
  }
    public static void main(String[] args) {
        int []tasks = {3,2,1}, workers = {0,3,3};
        int pills = 1, strength = 1;

        System.out.println(maxTaskAssign(tasks, workers, pills, strength));
    }
}
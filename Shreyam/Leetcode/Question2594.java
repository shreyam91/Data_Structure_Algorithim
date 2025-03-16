// Question: Minimum Time to Repair Car
// You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
// You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
// Return the minimum time taken to repair all the cars.
// Note: All the mechanics can repair the cars simultaneously.

// Example 1:
// Input: ranks = [4,2,3,1], cars = 10
// Output: 16

package shreyam.leetCode;

import java.util.Arrays;

public class Question2594 {
    public static long repairCars(int[] ranks, int cars) {
    long l = 0;
    long r = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;

    while (l < r) {
      final long m = (l + r) / 2;
      if (numCarsFixed(ranks, m) >= cars)
              r = m;
            else
              l = m + 1;
          }
      
          return l;
        }
      
    private static long numCarsFixed(int[] ranks, long minutes) {
    long carsFixed = 0;
    for (final int rank : ranks)
      carsFixed += Math.sqrt(minutes / rank);
    return carsFixed;
  }
    public static void main(String[] args) {
        int ranks[] = {4,2,3,1};
        int cars = 10;
        long res =  repairCars(ranks, cars);
        System.out.println(res);
    }
}

// Question: Put Marbles in Bags.... 
// You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.
// Divide the marbles into the k bags according to the following rules:
// No bag is empty.
// If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
// If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
// The score after distributing the marbles is the sum of the costs of all the k bags.
// Return the difference between the maximum and minimum scores among marble distributions.

// Example 1:
// Input: weights = [1,3,5,1], k = 2
// Output: 4

package shreyam.leetCode;

import java.util.Arrays;

public class Question2551 {
    public static long putMarbles(int[] weights, int k) {
    int[] arr = new int[weights.length - 1]; 
    long mn = 0;
    long mx = 0;

    for (int i = 0; i < arr.length; ++i)
      arr[i] = weights[i] + weights[i + 1];

    Arrays.sort(arr);

    for (int i = 0; i < k - 1; ++i) {
      mn += arr[i];
      mx += arr[arr.length - 1 - i];
    }

    return mx - mn;
  }
    public static void main(String[] args) {
        int weights[] = {1,3,5,1};
        int k = 2;

        long result = putMarbles(weights, k);
        System.out.println(result);

    }
}

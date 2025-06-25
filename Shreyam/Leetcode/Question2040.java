// Question: Kth Smallest Product of Two Sorted Arrays

// Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 
// Example 1:
// Input: nums1 = [2,5], nums2 = [3,4], k = 2
// Output: 8

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2040{
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    List<Integer> A1 = new ArrayList<>();
    List<Integer> A2 = new ArrayList<>();
    List<Integer> B1 = new ArrayList<>();
    List<Integer> B2 = new ArrayList<>();

    seperate(nums1, A1, A2);
    seperate(nums2, B1, B2);

    final long negCount = A1.size() * B2.size() + A2.size() * B1.size();
    int sign = 1;

    if (k > negCount) {
      k -= negCount; 
    } else {
      k = negCount - k + 1;
      sign = -1;
      List<Integer> temp = B1;
      B1 = B2;
      B2 = temp;
    }

    long l = 0;
    long r = (long) 1e10;

    while (l < r) {
      final long m = (l + r) / 2;
      if (numProductNoGreaterThan(A1, B1, m) + numProductNoGreaterThan(A2, B2, m) >= k)
        r = m;
      else
        l = m + 1;
    }

    return sign * l;
  }

  private static void seperate(int[] arr, List<Integer> A1, List<Integer> A2) {
    for (final int a : arr)
      if (a < 0)
        A1.add(-a);
      else
        A2.add(a);
    Collections.reverse(A1); 
  }

  private static long numProductNoGreaterThan(List<Integer> A, List<Integer> B, long m) {
    long count = 0;
    int j = B.size() - 1;
    for (final long a : A) {
      while (j >= 0 && a * B.get(j) > m)
        --j;
      count += j + 1;
    }
    return count;
  }
    public static void main(String[] args) {
        int [] nums1 = {2,5}, nums2 = {3,4};
        int k = 2;
        System.out.println(kthSmallestProduct(nums1, nums2, k));
    }
}
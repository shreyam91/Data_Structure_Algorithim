// Question: Count Good Triplets in an Array.... 
// You are given two 0-indexed arrays nums1 and nums2 of length n, both of which are permutations of [0, 1, ..., n - 1].
// A good triplet is a set of 3 distinct values which are present in increasing order by position both in nums1 and nums2. In other words, if we consider pos1v as the index of the value v in nums1 and pos2v as the index of the value v in nums2, then a good triplet will be a set (x, y, z) where 0 <= x, y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
// Return the total number of good triplets.

// Example 1:
// Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3]
// Output: 1

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question2179{
    private static long[] segTree;

    private static void updateSegTree(int stIdx, int start, int end, int queryIdx) {
        if (end < queryIdx || start > queryIdx) return;
        if (start == end) {
            segTree[stIdx]++;
            return;
        }
        int mid = start + (end - start) / 2;
        updateSegTree(2 * stIdx, start, mid, queryIdx);
        updateSegTree(2 * stIdx + 1, mid + 1, end, queryIdx);
        segTree[stIdx] = segTree[2 * stIdx] + segTree[2 * stIdx + 1];
    }

    private static long rangeSumQuery(int stIdx, int start, int end, int qs, int qe) {
        if (qs > end || qe < start) return 0;
        if (start >= qs && end <= qe) return segTree[stIdx];
        int mid = start + (end - start) / 2;
        long leftSum = rangeSumQuery(2 * stIdx, start, mid, qs, qe);
        long rightSum = rangeSumQuery(2 * stIdx + 1, mid + 1, end, qs, qe);
        return leftSum + rightSum;
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        segTree = new long[4 * n + 1];

        Map<Integer, Integer> nums2ValIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums2ValIdx.put(nums2[i], i);
        }

        updateSegTree(1, 0, n - 1, nums2ValIdx.get(nums1[0]));

        long countGoodTriplets = 0;
        for (int i = 1; i < n - 1; i++) {
            int nums2Idx = nums2ValIdx.get(nums1[i]);
            long commonLeftElements = rangeSumQuery(1, 0, n - 1, 0, nums2Idx);
            long uncommonLeftItems = i - commonLeftElements;
            long commonRightElements = (n - nums2Idx - 1) - uncommonLeftItems;
            countGoodTriplets += commonLeftElements * commonRightElements;

            updateSegTree(1, 0, n - 1, nums2Idx);
        }
        return countGoodTriplets;
    }
    public static void main(String[] args) {
        int nums1[] = {2,0,1,3};
        int nums2[] = {0,1,2,3};

        long res = goodTriplets(nums1, nums2);
        System.out.println(res);
    }
}
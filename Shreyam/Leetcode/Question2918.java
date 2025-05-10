// Question: Minimum Equal Sum of Two Arrays After Replacing Zeros

// You are given two arrays nums1 and nums2 consisting of positive integers.
// You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.
// Return the minimum equal sum you can obtain, or -1 if it is impossible.

// Example 1:
// Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
// Output: 12

package shreyam.leetCode;

public class Question2918{
    private static void calculate(long[] minSumZeroCount, int[] nums) {
        for (int ele : nums) {
            if (ele == 0) {
                minSumZeroCount[1]++;
                minSumZeroCount[0]++;
            } else {
                minSumZeroCount[0] += ele;
            }
        }
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long[] minSumZeroCount1 = new long[2]; // [min_sum, zero_count]
        calculate(minSumZeroCount1, nums1);

        long[] minSumZeroCount2 = new long[2];
        calculate(minSumZeroCount2, nums2);

        if ((minSumZeroCount1[0] < minSumZeroCount2[0] && minSumZeroCount1[1] == 0) ||
            (minSumZeroCount2[0] < minSumZeroCount1[0] && minSumZeroCount2[1] == 0)) {
            return -1;
        }
        return Math.max(minSumZeroCount1[0], minSumZeroCount2[0]);
    }
    public static void main(String[] args) {
        int [] nums1 = {3,2,0,1,0}, nums2 = {6,5,0};
        System.out.println(minSum(nums1, nums2));
    }
}
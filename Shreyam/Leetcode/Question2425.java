// Question: Bitwise XOR of All Pairings... 
// You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
// Return the bitwise XOR of all integers in nums3.

// Example 1:
// Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
// Output: 13
// Explanation:
// A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
// The bitwise XOR of all these numbers is 13, so we return 13.

package shreyam.leetCode;

public class Question2425 {
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;

        int m = nums2.length;
        if ((m & 1) == 1) {
            for (int ele : nums1) {
                ans ^= ele;
            }
        }

        int n = nums1.length;
        if ((n & 1) == 1) {
            for (int ele : nums2) {
                ans ^= ele;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        int res = xorAllNums(nums1, nums2);
        System.out.println(res);
    }
}

// Question: Count Equal and Divisible Pairs in an Array... 
// Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 
// Example 1:
// Input: nums = [3,1,2,2,2,1,3], k = 2
// Output: 4

package shreyam.leetCode;

public class Question2176 {
    public static int countPairs(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    if ((i * j) % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {3,1,2,2,2,1,3}; 
        int k = 2;

        int res = countPairs(nums, k);
        System.out.println(res);
    }
}
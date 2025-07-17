// Question: Find the Maximum Length of Valid Subsequence II

// You are given an integer array nums and a positive integer k.
// A subsequence sub of nums with length x is called valid if it satisfies:
// (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
// Return the length of the longest valid subsequence of nums.
 
// Example 1:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 5

package shreyam.leetCode;

public class Question3202 {
    public static int maximumLength(int[] nums, int k) {
        int[][] subarrayLengths = new int[k][k];  
        int maxLength = 0;  
        for (int num : nums) {
            int modValue = num % k;  
            for (int j = 0; j < k; ++j) {
                int requiredMod = (j - modValue + k) % k;  
                subarrayLengths[modValue][requiredMod] = subarrayLengths[requiredMod][modValue] + 1;

                maxLength = Math.max(maxLength, subarrayLengths[modValue][requiredMod]);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        int k =2;
        System.out.println(maximumLength(nums, k));
    }
}

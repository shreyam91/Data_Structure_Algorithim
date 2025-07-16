// Question: Find the Maximum Length of Valid Subsequence I

// You are given an integer array nums.
// A subsequence sub of nums with length x is called valid if it satisfies:
// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
// Return the length of the longest valid subsequence of nums.
// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: 4

package shreyam.leetCode;

public class Question3201 {
    public static int maximumLength(int[] nums) {
    int k = 2; 
        int[][] frequency = new int[k][k]; 
        int maxLength = 0; 

        for (int num : nums) { 
            num %= k; 
            for (int j = 0; j < k; ++j) { 
                int y = (j - num + k) % k; 
                frequency[num][y] = frequency[y][num] + 1; 
                maxLength = Math.max(maxLength, frequency[num][y]); 
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(maximumLength(nums));
    }
}

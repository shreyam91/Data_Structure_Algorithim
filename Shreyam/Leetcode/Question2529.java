// Question: Maximum Count of Positive Integer and Negative Integer... 
// Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
// In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
// Note that 0 is neither positive nor negative.


// Example 1:
// Input: nums = [-2,-1,-1,1,2,3]
// Output: 3
// Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

package shreyam.leetCode;

public class Question2529 {
    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int positive = 0, negative =0;

        for(int i =0; i<n;i++){
            if(nums[i] < 0){
                negative ++;
            }
            if(nums[i] > 0){
                positive ++;
            }
        }
        int count = Math.max(positive, negative);
            return count;
        
    }
    public static void main(String[] args) {
        int nums [] = {5,20,66,1314};
        int res = maximumCount(nums);
        System.out.println(res);
    }
}

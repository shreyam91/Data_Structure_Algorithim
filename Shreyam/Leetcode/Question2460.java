// Question: Apply Operation to an Array... 
// You are given a 0-indexed array nums of size n consisting of non-negative integers.
// You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:
// If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
// After performing all the operations, shift all the 0's to the end of the array.
// For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
// Return the resulting array.
// Note that the operations are applied sequentially, not all at once.

// Example 1:
// Input: nums = [1,2,2,1,1,0]
// Output: [1,4,2,0,0,0]

package shreyam.leetCode;

import java.util.Arrays;

public class Question2460 {
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int nonZeroIdx = 0;

        for(int i=0;i<n;i++){
            if(i<n-1 && nums[i] == nums[i+1]){
                nums[i] *=2;
                nums[i+1] = 0;
            }
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[nonZeroIdx];
                nums[nonZeroIdx] = temp;
                nonZeroIdx++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,2,1,1,0};
        int [] res = applyOperations(nums);
        System.out.println(Arrays.toString(res));
    }
}

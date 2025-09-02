// Question: 3 Sum 

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
// The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

package shreyam.twoPointer;

import java.util.Arrays;

public class ThreeSum {
    public static int[] threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

    //     for( int i=0; i<len;i++){
    //         for(int j=i+1;j<len;j++){
    //             for(int k=j+1;k<len;k++){
    //                 if(nums[i]+nums[j]+nums[k]==0){
    //                     return new int[]{nums[i],nums[j],nums[k]};
    //             }
    //         }
    //     }
    // }
        for (int i = 0; i < len - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
                int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    return new int[]{nums[i], nums[left], nums[right]};
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return null;    
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums)));
    }
}

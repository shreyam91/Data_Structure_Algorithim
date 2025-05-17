// Question: Sort Colors

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

package shreyam.leetCode;

import java.util.Arrays;

public class Question75{
    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
    }
}


// Another approach
// public void swap(int nums[] ,int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
//     public void sortColors(int[] nums) {
//         int start =0;
//         int end = nums.length-1;
//         int index =0;
//         while( index<= end){
//             if(nums[index] == 0){
//                 swap(nums,index,start);
//                 index++;
//                 start++;
//             }else if(nums[index] == 2){
//                 swap(nums,index,end);
//                 end--;
//             }else{
//                 index++;
//             }
//         }
//     }
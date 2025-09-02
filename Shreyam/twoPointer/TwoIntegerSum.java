// Question: Two Integer Sum II

// Given an array of integers numbers that is sorted in non-decreasing order.
// Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

// There will always be exactly one valid solution.
// Your solution must use O(1) additional space.

// Example 1:
// Input: numbers = [1,2,3,4], target = 3
// Output: [1,2]

package shreyam.twoPointer;

import java.util.Arrays;

public class TwoIntegerSum {
    static int [] twoSum(int[] numbers, int target){
        int len = numbers.length;
    //     for(int i=0; i<len;i++){
    //         for(int j=i+1;j<len;j++){
    //             if(numbers[i]+numbers[j]==target){
    //                 return new int[]{i+1,j+1};
    //             }
    //     }
    // }

        int left =0;
        int right = len-1;

        while(left<right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left+1,right+1};
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return numbers;
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}

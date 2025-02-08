// Question:- Indexes of Subarray Sum.. 
// Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

// Note: If no such array is possible then, return [-1].
// Examples:
// Input: arr[] = [1, 2, 3, 7, 5], target = 12
// Output: [2, 4]
// Explanation: The sum of elements from 2nd to 4th position is 12.

package shreyam.gfg;

import java.util.ArrayList;

public class indexesOfSubarraySum {
    static ArrayList<Integer> subarraySum(int []arr, int target){
        int length = arr.length;
        int sum = 0, start =0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<length;i++){
            sum += arr[i];

            while(sum>target && start <= i){
                sum -=arr[start];
                start++;
                }

            if(sum == target){
                result.add(start+1);
                result.add(i+1);
                return result;
            }
        } 

        result.add(-1);
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,7,5};
        int target = 12;
        ArrayList<Integer> result = subarraySum(arr, target);
        System.out.println(result);
    }
}

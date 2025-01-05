// Question: Count Pairs whose sum is less than target... 
// Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.

// Examples:

// Input: arr[] = [7, 2, 5, 3], target = 8
// Output: 2
// Explanation: There are 2 pairs with sum less than 8: (2, 5) and (2, 3). 

package Shreyam.GFG;

import java.util.Arrays;

public class countPairsWhoseSumLessThanTarget {
    public static int countPairs(int[]arr, int target){

        // Brute force approach..
        // int count =0;
        // int len = arr.length;
        // for(int i=0;i<len;i++){
        //     for(int j=i+1;j<len;j++){
        //         if(arr[i]+arr[j] < target){
        //             count++;
        //         }
        //     }
        // }

        // Optimal Approach...
        Arrays.sort(arr);
        int len = arr.length;
        int count =0,left=0,right=len-1;
        
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum<target){
                count += (right-left);
                left++;
            }else{
                right--;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int arr[] = {7,2,5,3};
        int target = 8;
        int result = countPairs(arr, target);
        System.out.println("Total numbers of pairs which are less than target is: " + result);
    }
}

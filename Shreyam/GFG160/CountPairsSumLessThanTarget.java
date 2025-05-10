// Question: Count Pairs whose sum is less than target
// Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.

// Examples:
// Input: arr[] = [7, 2, 5, 3], target = 8
// Output: 2

package shreyam.GFG160;

import java.util.Arrays;

public class CountPairsSumLessThanTarget {
    static int countPairs(int arr[], int target) {
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
        int arr[] = {7, 2, 5, 3};
        int target = 8;

        System.out.println(countPairs(arr, target));
    }
}

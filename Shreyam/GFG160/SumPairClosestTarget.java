// Question: Sum Pair closest to target

// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

// Examples:
// Input: arr[] = [10, 30, 20, 5], target = 25
// Output: [5, 20]


package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestTarget {

    public static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int start =0, end = arr.length-1;
        int diff = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        
        while(start<end){
            int pairSum = arr[start]+ arr[end];
            if (Math.abs(target - pairSum) < diff) {
                diff = Math.abs(target - pairSum);
                ans = Arrays.asList(arr[start], arr[end]);
            }
            
            if (pairSum < target) {
                start++;
            } else if (pairSum > target) {
                end--;
            } else {
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10, 30, 20, 5};
        int target = 25;
        System.out.println(sumClosest(arr, target));
    }
}

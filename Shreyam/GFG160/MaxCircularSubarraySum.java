// Question: Max Circular Subarray Sum... 
// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

// Examples:
// Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
// Output: 22

package shreyam.GFG160;

public class MaxCircularSubarraySum {
    public static int circularSubarraySum(int[] arr) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0, totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            s1 += arr[i];
            s2 += arr[i];
            
            if (s1 < 0) s1 = 0;
            
            if (s2 > 0) s2 = 0;
            
            maxSum = Math.max(maxSum, s1);
            
            minSum = Math.min(minSum, s2);
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(circularSubarraySum(arr));  
    }
}

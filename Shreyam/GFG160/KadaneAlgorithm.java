// Question: Kadane's Algorithm.... 

// Given an integer array arr[]. You need to find the maximum sum of a subarray.
// Examples:
// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11

package shreyam.GFG160;

public class KadaneAlgorithm {
    static int maxSubarraySum(int[] arr) {
        int maxi = Integer.MIN_VALUE, curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (maxi < curr) {
                maxi = curr;
            }
            if (curr < 0) {
                curr = 0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}

// Question: Max Score from Subarray Mins

// You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest and second smallest elements across all subarrays (of size >= 2) of the given array.

// Examples :
// Input: arr[] = [4, 3, 5, 1]
// Output: 8


package shreyam.gfg;

public class MaxScoreSubarrayMins {
    public static int maxSum(int arr[]) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(arr[i] + arr[i - 1], ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr [] = {4,3,5,1};
        System.out.println(maxSum(arr));
    }
}

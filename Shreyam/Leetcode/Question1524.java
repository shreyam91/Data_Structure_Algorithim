// Question: Number of sub-arrays with Odd Sum... 
// Given an array of integers arr, return the number of subarrays with an odd sum.
// Since the answer can be very large, return it modulo 109 + 7.

// Example 1:
// Input: arr = [1,3,5]
// Output: 4
// Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
// All sub-arrays sum are [1,4,9,3,8,5].
// Odd sums are [1,9,3,5] so the answer is 4.

package shreyam.leetCode;

public class Question1524 {
    public static int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0;
        int evenCount = 1; // Prefix sum of 0 is even
        int total = 0;
        int prefixSum = 0;

        for (int ele : arr) {
            prefixSum += ele;
            if ((prefixSum & 1) == 1) { // If prefix sum is odd
                total = (total + evenCount) % MOD;
                oddCount++;
            } else { // If prefix sum is even
                total = (total + oddCount) % MOD;
                evenCount++;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5};
        int res = numOfSubarrays(arr);
        System.out.println(res);
    }
}

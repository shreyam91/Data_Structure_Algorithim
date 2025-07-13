// Question: Maximum sum of elements not part of LIS

// Given an array arr[] of positive integers, your task is to find the maximum possible sum of all elements that are not part of the Longest Increasing Subsequence (LIS).

// Examples:
// Input: arr[] = [4, 6, 1, 2, 3, 8]
// Output: 10

package shreyam.gfg;

public class MaximumSumElementsPartLIS {
    public static int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int total = 0;
        int maxLen = 0;
        int minLisSum = Integer.MAX_VALUE;

        int[] len = new int[n];  
        int[] sum = new int[n];  

        for (int i = 0; i < n; i++) {
            total += arr[i];
            len[i] = 1;
            sum[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && len[j] + 1 >= len[i]) {
                    len[i] = len[j] + 1;
                    sum[i] = sum[j] + arr[i];
                }
            }

            maxLen = Math.max(maxLen, len[i]);
        }

        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                minLisSum = Math.min(minLisSum, sum[i]);
            }
        }

        return total - minLisSum;
    }
    public static void main(String[] args) {
       int arr[] = {4, 6, 1, 2, 3, 8};
        System.out.println(nonLisMaxSum(arr));
    }
}

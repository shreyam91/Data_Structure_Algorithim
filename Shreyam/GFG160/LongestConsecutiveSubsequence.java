// Question: Longest Consecutive Subsequence... 
// Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

// Examples:
// Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
// Output: 6

package shreyam.GFG160;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] arr) {
        int[] freq = new int[1000001];
        int count = 0;
        int ans = Integer.MIN_VALUE;
        int maxi = -1;

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
            maxi = Math.max(maxi, arr[i]);
        }

        for (int i = 0; i <= maxi; i++) {
            if (freq[i] > 0) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }

        ans = Math.max(ans, count);

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr));
    }
}

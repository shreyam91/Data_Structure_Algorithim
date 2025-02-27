// Question: Length of Longest Fibonacci Subsequence... 
// A sequence x1, x2, ..., xn is Fibonacci-like if: 
// n >= 3 xi + xi+1 == xi+2 for all i + 2 <= n
// Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
// A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

// Example 1:
// Input: arr = [1,2,3,4,5,6,7,8]
// Output: 5
// Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

package shreyam.leetCode;

public class Question873 {
    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        int maxLen=0;
        for(int cur=2;cur<n;cur++){
            int start = 0;
            int end = cur-1;
            while(start<end){
                int sum = arr[start] + arr[end];
                if(sum < arr[cur]){
                    start++;
                }else if(sum > arr[cur]){
                    end--;
                }else{
                    dp[end][cur] = dp[start][end] + 1;
                    maxLen = Math.max(maxLen, dp[end][cur]);
                    start++;
                    end--;
                }
            }
        }
        return (maxLen==0)?0:maxLen + 2;
    }

    // Brute force... 
    // public int lenLongestFibSubseq(int[] arr) {
    //     int n = arr.length;
    //     Set<Integer> numSet = new HashSet<>();
    //     for (int num : arr) {
    //         numSet.add(num);
    //     }
    //     int maxLen = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             int prev = arr[j];
    //             int curr = arr[i] + arr[j];
    //             int len = 2;
    //             while (numSet.contains(curr)) {
    //                 int temp = curr;
    //                 curr += prev;
    //                 prev = temp;
    //                 maxLen = Math.max(maxLen, ++len);
    //             }
    //         }
    //     }
    //     return maxLen;
    // }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int res = lenLongestFibSubseq(arr);
        System.out.println(res);
    }
}

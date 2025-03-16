// Qustion: Minimum Jumps... 
// Difficulty: MediumAccuracy: 11.91%Submissions: 965K+Points: 4
// You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.
// For example:
// If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
// If arr[i] = 0, you cannot jump forward from that position.
// Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.
// Note:  Return -1 if you can't reach the end of the array.

// Examples : 
// Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
// Output: 3 
// Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 

package shreyam.gfg;

public class MinimumJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;

        int jump = 1, jumpEnd = arr[0], maxReach = arr[0];
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jump;

            maxReach = Math.max(maxReach, i + arr[i]);

            if (i == jumpEnd) {
                if (i == maxReach) return -1;

                jump++;
                jumpEnd = maxReach;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
       int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
       int res = minJumps(arr);
       System.out.println(res);
    }
}

// Question:- Minimum Number of Operations to Move All Balls to Each Box... 

// You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

// In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.

// Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

// Each answer[i] is calculated considering the initial state of the boxes.

// Example 1:

// Input: boxes = "110"
// Output: [1,1,3]
// Explanation: The answer for each box is as follows:
// 1) First box: you will have to move one ball from the second box to the first box in one operation.
// 2) Second box: you will have to move one ball from the first box to the second box in one operation.
// 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.

package Shreyam.leetCode;

public class Question1769 {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int sum = 0;
        int rightOnes = 0;
        int[] res = new int[n];
        int prefixSum = 0;
        int leftOnes = 0;
        
        // Calculate initial sum and count of '1's to the right
        for (int i = 0; i < n; ++i) {
            if (boxes.charAt(i) == '1') {
                sum += i;
                rightOnes++;
            }
        }
        
        // Calculate moves per position
        for (int i = 0; i < n; ++i) {
            int moves = sum + prefixSum;
            res[i] = moves;
            
            // Update both sum and prefixSum
            if (boxes.charAt(i) == '1') {
                leftOnes++;
                rightOnes--;
            }
            prefixSum += leftOnes;
            sum -= rightOnes;
        }
        
        return res;
    }
    public static void main(String[] args) {
        String s = "110";
        int result[] = minOperations(s);

        for (int res : result) {
            System.out.print("Output: " + res + " ");
        }
    }
}

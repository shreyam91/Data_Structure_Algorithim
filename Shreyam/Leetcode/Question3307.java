// Question: Find the K-th Character in String Game II

// Alice and Bob are playing a game. Initially, Alice has a string word = "a".
// You are given a positive integer k. You are also given an integer array operations, where operations[i] represents the type of the ith operation.
// Now Bob will ask Alice to perform all operations in sequence:
// If operations[i] == 0, append a copy of word to itself.
// If operations[i] == 1, generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word. For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
// Return the value of the kth character in word after performing all the operations.
// Note that the character 'z' can be changed to 'a' in the second type of operation.

// Example 1:
// Input: k = 5, operations = [0,0,0]
// Output: "a"

package shreyam.leetCode;

import java.util.Arrays;
import java.util.List;

public class Question3307 {
    public static char kthCharacter(long k, List<Integer> operations) {
        int countOps = 0;
        long val = k;
        while (val > 1) {
            int jumps = (int) Math.ceil(Math.log(val) / Math.log(2));
            val -= (long) Math.pow(2, jumps - 1);
            countOps += operations.get(jumps - 1);
        }
        return (char) ('a' + (countOps % 26));
    }
    public static void main(String[] args) {
        long k = 5;
List<Integer> operations = Arrays.asList(0, 0, 0);        System.out.println(kthCharacter(k, operations));
    }
}


// final int operationsCount = (int) Math.ceil(Math.log(k) / Math.log(2));
//     int increases = 0;

//     for (int i = operationsCount - 1; i >= 0; --i) {
//       final long halfSize = 1L << i;
//       if (k > halfSize) {
//         k -= halfSize; // Move k from the right half to the left half.
//         increases += operations[i];
//       }
//     }

//     return (char) ('a' + increases % 26);
// You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters. Return the score of s.
// Example 1:

// Input: s = "hello"

// Output: 13

// Explanation:

// The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

package LeetCode;

import java.util.Scanner;

public class scoreOfString {

    public static int scoreOfStr(String s) {
        int ans= 0;

        for(int i=1; i<s.length();i++){
            ans += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        
        int result = scoreOfStr(inputString);
        System.out.println("Score of the string: " + result);

        scanner.close();
    }
}

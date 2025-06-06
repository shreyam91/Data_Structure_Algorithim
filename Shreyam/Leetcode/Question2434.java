// Question: Using a Robot to Print the Lexicographically Smallest String
// You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:

// Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
// Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
// Return the lexicographically smallest string that can be written on the paper.

 

// Example 1:

// Input: s = "zza"
// Output: "azz"


package shreyam.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question2434 {
    public static String robotWithString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int minCh = 0; 

        for (char c : s.toCharArray()) {
            stack.push(c);
            cnt[c - 'a']--;

            while (minCh < 26 && cnt[minCh] == 0) {
                minCh++;
            }

            while (!stack.isEmpty() && (stack.peek() - 'a') <= minCh) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
    public static void main(String[] args) {
        String s = "zza";
        System.out.println(robotWithString(s));
    }
}

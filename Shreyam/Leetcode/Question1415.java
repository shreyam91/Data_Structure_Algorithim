// Question: The k th Lexicographical String of All Happy Strings of Length n
// A happy string is a string that:
// consists only of letters of the set ['a', 'b', 'c'].
// s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
// For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
// Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
// Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

// Example 1:
// Input: n = 1, k = 3
// Output: "c"
// Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question1415 {
    public static String getHappyString(int n, int k) {
        List<String> sizeN = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Push all start points
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() == n) {
                sizeN.add(curr);
                continue;
            }

            // Build next 2 strings
            char lastChar = curr.charAt(curr.length() - 1);
            if (lastChar == 'a') {
                queue.offer(curr + "b");
                queue.offer(curr + "c");
            } else if (lastChar == 'b') {
                queue.offer(curr + "a");
                queue.offer(curr + "c");
            } else {
                queue.offer(curr + "a");
                queue.offer(curr + "b");
            }
        }

        if (sizeN.size() < k) {
            return "";
        }
        return sizeN.get(k - 1);
    }
    public static void main(String[] args) {
        int n =1, k =3;
        String res = getHappyString(n, k);
        System.out.println(res);
    }
}

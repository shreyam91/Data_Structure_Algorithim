// Question: Lexicographically Minimum String After Removing Stars

// You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
// While there is a '*', do the following operation:
// Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
// Return the lexicographically smallest resulting string after removing all '*' characters.

// Example 1:
// Input: s = "aaba*"
// Output: "aab"

package shreyam.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3170 {
    public static String clearStars(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Map<Character, Deque<Integer>> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                for (char c = 'a'; c <= 'z'; c++) {
                    Deque<Integer> stack = map.get(c);
                    if (stack != null && !stack.isEmpty()) {
                        toRemove.add(stack.removeLast());
                        break;
                    }
                }
            } else {
                map.putIfAbsent(ch, new ArrayDeque<>());
                map.get(ch).addLast(i);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toRemove.contains(i) && s.charAt(i) != '*') {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
    public static void main(String[] args) {
        String s = "aaba*";
        System.out.println(clearStars(s));
    }
}

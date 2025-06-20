// Question: Maximum Manhattan Distance After K changes

// You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:
// 'N' : Move north by 1 unit.
// 'S' : Move south by 1 unit.
// 'E' : Move east by 1 unit.
// 'W' : Move west by 1 unit.
// Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.
// Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.
// The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
 
// Example 1:
// Input: s = "NWSE", k = 1
// Output: 3

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question3443{
    public static int maxDistance(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxDist = 0;

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            int vertical = Math.abs(freq.getOrDefault('N', 0) - freq.getOrDefault('S', 0));
            int horizontal = Math.abs(freq.getOrDefault('E', 0) - freq.getOrDefault('W', 0));
            int currDist = vertical + horizontal;

            int northSouthChanges = Math.min(k, Math.min(freq.getOrDefault('E', 0), freq.getOrDefault('W', 0)));
            int remainingK = k - northSouthChanges;
            int eastWestChanges = Math.min(remainingK, Math.min(freq.getOrDefault('N', 0), freq.getOrDefault('S', 0)));

            maxDist = Math.max(maxDist, currDist + 2 * (northSouthChanges + eastWestChanges));
        }

        return maxDist;
    }
    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(maxDistance(s, k));
    }
}
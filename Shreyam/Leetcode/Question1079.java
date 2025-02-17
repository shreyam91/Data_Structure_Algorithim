// Question: Letter Tile Possibilities... 
// You have n  tiles, where each tile has one letter tiles[i] printed on it.
// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

// Example 1:
// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

package shreyam.leetCode;

public class Question1079 {
    private static int buildString(int[] freq) {
        int ways = 0;
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) { 
                freq[i]--; 
                ways += 1 + buildString(freq); 
                freq[i]++; 
            }
        }
        return ways;
    }

    public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return buildString(freq);
    }
    public static void main(String[] args) {
        String tiles = "AAB";
        int res = numTilePossibilities(tiles);
        System.out.println(res);
    }
}

// Question: Lexicographically Smallest Equivalent String 

// You are given two strings of the same length s1 and s2 and a string baseStr.
// We say s1[i] and s2[i] are equivalent characters.
// For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
// Equivalent characters follow the usual rules of any equivalence relation:
// Reflexivity: 'a' == 'a'.
// Symmetry: 'a' == 'b' implies 'b' == 'a'.
// Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
// For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
// Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

// Example 1:
// Input: s1 = "parker", s2 = "morris", baseStr = "parser"
// Output: "makkek"

package shreyam.leetCode;

public class Question1061{
    static int[] parent = new int[26];

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  
        }
        return parent[x];
    }

    public static void unionFind(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX == pY) return;
        if (pX < pY) {
            parent[pY] = pX;
        } else {
            parent[pX] = pY;
        }
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            unionFind(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder ans = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            ans.append((char)(find(c - 'a') + 'a'));
        }

        return ans.toString();
    }
    public static void main(String[] args) {
       String s1 = "parker", s2 = "morris", baseStr = "parser";
       System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }
}
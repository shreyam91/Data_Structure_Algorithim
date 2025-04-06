// Question: Search Pattern (KMP-Algorithm)
// Difficulty: HardAccuracy: 45.04%Submissions: 105K+Points: 8
// Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.

// Examples :

// Input: txt = "abcab", pat = "ab"
// Output: [0, 3]

package shreyam.GFG160;

import java.util.ArrayList;

public class SearchPattern {
    
    public ArrayList<Integer> searchPattern(String txt, String pat) {
        ArrayList<Integer> result = new ArrayList<>();
        int N = txt.length();
        int M = pat.length();

        int[] lps = computeLPS(pat);

        int i = 0; 
        int j = 0; 

        while (i < N) {
            if (j < M && pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                result.add(i - j ); 
                j = lps[j - 1];
            } else if (i < N && (j == 0 || pat.charAt(j) != txt.charAt(i))) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPS(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int len = 0; 

        lps[0] = 0; 

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; 
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        SearchPattern searchPattern = new SearchPattern();
        String txt = "abcab";
        String pat = "ab";

        ArrayList<Integer> result = searchPattern.searchPattern(txt, pat);

        System.out.println("Pattern found at indices (1-based): " + result);
    }
}


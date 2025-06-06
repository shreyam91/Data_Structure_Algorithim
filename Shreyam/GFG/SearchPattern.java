// Question: Search Pattern (Rabin-Karp Algorithm)

// Given two strings:
// A text string in which you want to search.
// A pattern string that you are looking for within the text.
// Return all positions (1-based indexing) where the pattern occurs as a substring in the text. If the pattern does not occur, return an empty list.
// All characters in both strings are lowercase English letters (a to z).

// Examples:
// Input: text = "birthdayboy", pattern = "birth"
// Output: [1]

package shreyam.gfg;

import java.util.ArrayList;

public class SearchPattern{
    private static boolean isMatch(String txt, String pat, int idx) {
        for (int i = 0; i < pat.length(); i++) {
            if (txt.charAt(idx + i) != pat.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    static ArrayList<Integer> search(String pat, String txt) {
        int m = pat.length(); 
        int n = txt.length(); 

        int base = 26;        
        int mod  = 101;       

        ArrayList<Integer> result = new ArrayList<>();
        int patHash = 0; 
        int txtHash = 0; 
        int power   = 1;

        for (int i = m - 1; i >= 0; i--) {
            int patVal = pat.charAt(i) - 'a' + 1;
            int txtVal = txt.charAt(i) - 'a' + 1;

            patHash = (patHash + patVal * power) % mod;
            txtHash = (txtHash + txtVal * power) % mod;
            power   = (power * base) % mod;
        }

        if (txtHash == patHash && isMatch(txt, pat, 0)) {
            result.add(1); 
        }

        int highestPower = 1;
        for (int i = 1; i < m; i++) {
            highestPower = (highestPower * base) % mod;
        }

        for (int i = 1; i <= n - m; i++) {
            int leftVal = txt.charAt(i - 1) - 'a' + 1;

            txtHash = (txtHash - (leftVal * highestPower) % mod + mod) % mod;
            txtHash = (txtHash * base) % mod;

            int newVal = txt.charAt(i + m - 1) - 'a' + 1;
            txtHash = (txtHash + newVal) % mod;

            if (txtHash == patHash && isMatch(txt, pat, i)) {
                result.add(i + 1); 
            }
        }

        return result;
    }
    public static void main(String[] args) {
       String text = "birthdayboy", pattern = "birth";
        System.out.println(search(text, pattern));
    }
}
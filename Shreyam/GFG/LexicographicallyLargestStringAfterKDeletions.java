// Question: Lexicographically Largest String After K Deletions 

// Given a string s consisting of lowercase English letters and an integer k, your task is to remove exactly k characters from the string. The resulting string must be the largest possible in lexicographical  order, while maintain the relative order of the remaining characters.

// Examples:
// Input: s = "ritz", k = 2
// Output: tz 

package shreyam.gfg;

public class LexicographicallyLargestStringAfterKDeletions {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int toRemove = k;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (res.length() > 0 && toRemove > 0 &&
                   res.charAt(res.length() - 1) < s.charAt(i)) {
                res.deleteCharAt(res.length() - 1);
                toRemove--;
            }
            res.append(s.charAt(i));
        }
        return res.substring(0, n - k);
    }
    public static void main(String[] args) {
        String s = "ritz";
        int k = 2;
        System.out.println(maxSubseq(s, k));
    }
}

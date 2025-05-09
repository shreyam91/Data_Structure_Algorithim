// Question: Largest number in K swaps
// Given a number k and string s of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of s at most k times.

// Examples :
// Input: s = "1234567", k = 4
// Output: 7654321

package shreyam.gfg;


public class LargestNumberKSwaps{
    static String ans = "";

    static void solve(int idx, int n, String str, int k) {
        if (k == 0 || idx >= n) {
            if (str.compareTo(ans) > 0) {
                ans = str;
            }
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            if (str.charAt(i) > str.charAt(idx)) {
                str = swap(str, i, idx);
                solve(idx + 1, n, str, k - 1);
                str = swap(str, i, idx); // backtrack
            }
        }

        solve(idx + 1, n, str, k);
    }

    public static String findMaximumNum(String str, int k) {
        int n = str.length();
        ans = str;
        solve(0, n, str, k);
        return ans;
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
    public static void main(String[] args) {
        String s = "1234567";
        int k = 4;
        System.out.println(findMaximumNum(s, k));
    }
}
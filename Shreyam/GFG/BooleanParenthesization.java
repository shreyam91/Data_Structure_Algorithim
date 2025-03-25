// Question: Boolean Parenthesization... 
// You are given a boolean expression s containing
//     'T' ---> true
//     'F' ---> false 
// and following operators between symbols
//    &   ---> boolean AND
//     |   ---> boolean OR
//    ^   ---> boolean XOR
// Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
// Note: The answer is guaranteed to fit within a 32-bit integer.

// Examples:
// Input: s = "T|T&F^T"
// Output: 4

package shreyam.gfg;

public class BooleanParenthesization {
    public boolean evaluate(int b1, int b2, char op) {
        if (op == '&') {
            return (b1 & b2) != 0;
        } else if (op == '|') {
            return (b1 | b2) != 0;
        } else {
            return (b1 ^ b2) != 0;
        }
    }

    public int helper(int start, int end, int req, String s, int[][][] dp) {
        if (start == end) {
            return (req == (s.charAt(start) == 'T' ? 1 : 0)) ? 1 : 0;
        }

        if (dp[start][end][req] != -1) {
            return dp[start][end][req];
        }

        int ans = 0;

        for (int k = start + 1; k < end; k += 2) {
            int leftTrue = helper(start, k - 1, 1, s, dp);
            int leftFalse = helper(start, k - 1, 0, s, dp);

            int rightTrue = helper(k + 1, end, 1, s, dp);
            int rightFalse = helper(k + 1, end, 0, s, dp);

            if ((evaluate(1, 1, s.charAt(k)) ? 1 : 0) == req) {
                ans += leftTrue * rightTrue;
            }
            if ((evaluate(1, 0, s.charAt(k)) ? 1 : 0) == req) {
                ans += leftTrue * rightFalse;
            }
            if ((evaluate(0, 1, s.charAt(k)) ? 1 : 0) == req) {
                ans += leftFalse * rightTrue;
            }
            if ((evaluate(0, 0, s.charAt(k)) ? 1 : 0) == req) {
                ans += leftFalse * rightFalse;
            }
        }

        dp[start][end][req] = ans;
        return ans;
    }

    public int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }

        return helper(0, n - 1, 1, s, dp);
    }

    public static void main(String[] args) {
        BooleanParenthesization obj = new BooleanParenthesization();
        String s = "T|T&F^T"; // Example input
        System.out.println("Ways to evaluate the expression to True: " + obj.countWays(s));
    }
}
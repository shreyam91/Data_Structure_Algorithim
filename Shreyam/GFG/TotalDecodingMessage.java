// Question: Total Decoding Message... 
// A message containing letters A-Z is being encoded to numbers using the following mapping:
// 'A' -> 1, 'B' -> 2, 'Z' -> 26
// You are given a string digits. You have to determine the total number of ways that message can be decoded.

// Examples:
// Input: digits = "123"
// Output: 3
// Explanation: "123" can be decoded as "ABC"(1, 2, 3), "LC"(12, 3) and "AW"(1, 23).

package shreyam.gfg;

import java.util.Arrays;

public class TotalDecodingMessage {
    static int countWays(String digits){
        int dp[] = new int[digits.length() +1];
        Arrays.fill(dp,-1);
        return find(0,digits,dp);
    }

    static int find(int i, String str, int dp[]){
        int length = str.length();

        if(i >= length) {
            return 1;
        }
        if(str.charAt(i)  == 0){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int c1 = find(i+1, str,dp);
        int c2 = 0;

        if(i+1 < length){
            int num = Integer.parseInt(str.substring(i, i+2));
            if(num <= 26 && num >= 10){
                c2 = find(i+2,str,dp);
            }
        }

        return dp[i] = c1+c2;
        
    }
    public static void main(String[] args) {
        String digits = "123";
        int res = countWays(digits);
        System.out.println(res);
    }
}

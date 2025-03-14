// Question: Coin Change (Count ways)... 
// Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
// Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
// Answers are guaranteed to fit into a 32-bit integer. 
// Examples:
// Input: coins[] = [1, 2, 3], sum = 4
// Output: 4
// Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

package shreyam.gfg;

import java.util.Arrays;

public class CoinChange {
    static int[][] dp;
        private static int explore(int[] coins, int sum,int i)
        {
            if(sum==0 )return 1;
            if(i==coins.length)return 0;
            if(dp[i][sum]!=-1)return dp[i][sum];
        int exclude=explore(coins,sum,i+1);
        int include=0;
        if(sum-coins[i]>=0)
        {
            include=explore(coins,sum-coins[i],i);
          
        }
        return dp[i][sum]=include+exclude;
    }
    public static int count(int coins[], int sum) {
        int c=coins.length;
        dp=new int[c+1][sum+1];
        for(int[] row: dp)
        {
        Arrays.fill(row,-1);
            
        }
        return explore(coins,sum,0);
    }
        
    public static void main(String[] args) {
        int [] coins = {1,2,3};
        int sum =4;
        int res = count(coins, sum);
        System.out.println(res);
    }
}

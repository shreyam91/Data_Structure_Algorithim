// Question: Stock Buy & Sell: Max K Transactions Allowed... 
// In the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.
// A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.

// Examples :
// Input: prices[] = [10, 22, 5, 80], k = 2
// Output: 87

package shreyam.gfg;

import java.util.Arrays;

public class StcokBuySell {
    static int dp[][][];
    static int maxProfit(int prices[], int k) {
        dp = new int[prices.length][k+1][2];
        
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        return solve(prices,k,0,0);
    }
    
    static int solve(int prices[], int k, int idx, int holding){
        if(idx == prices.length){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        
        if(dp[idx][k][holding] != -1){
            return dp[idx][k][holding];
        }
        int transaction = 0;
        if(holding == 1){
            transaction = prices[idx] + solve(prices,k-1,idx+1,0);
        } else {
            transaction = -prices[idx] + solve(prices,k,idx+1,1);
        }
        int np_transact = solve(prices,k,idx+1,holding);
        return dp[idx][k][holding] = Math.max(transaction, np_transact);
    }
    public static void main(String[] args) {
        int [] prices = {10,22,5,80};
        int k =2;
        int res = maxProfit(prices, k);
        System.out.println(res);
    }
}

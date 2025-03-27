// Question:Stock Buy and Sell – Max one Transaction Allowed... 
// Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
// Note: Stock must be bought before being sold.

// Examples:
// Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
// Output: 8

package shreyam.GFG160;

public class StockBuySellMax {
    public static int maximumProfit(int prices[]) {
        int maxEle = 0;
        int maxProfit = 0;

        for(int i=prices.length-1; i>=0; i--){
            maxEle = Math.max(maxEle, prices[i]);
            maxProfit = Math.max(maxProfit, maxEle - prices[i]);
        }
            return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7, 10, 1, 3, 6, 9, 2};  
        int res = maximumProfit(prices);
        System.out.println(res); 
    }
}

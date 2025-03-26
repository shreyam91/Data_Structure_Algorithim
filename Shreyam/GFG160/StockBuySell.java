// Question: Stock Buy and Sell – Multiple Transaction Allowed... 
// The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
// Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

// Examples:
// Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
// Output: 865
package shreyam.GFG160;

public class StockBuySell {
    public static int maximumProfit(int prices[]) {
        int profit = 0;
        int length = prices.length;
        
        for(int i=0; i<length-1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));        
    }
}

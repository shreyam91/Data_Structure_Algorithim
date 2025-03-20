// Question: Stock Buy and Sell - Max 2 transaction Allowed... 

// In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.
// You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).

// Examples:
// Input: prices[] = [10, 22, 5, 75, 65, 80]
// Output: 87

package shreyam.gfg;

public class StockBuySell {
    public static int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE, s1 = 0, b2 = Integer.MAX_VALUE, s2 = 0;
        for (int p : prices) {
            b1 = Math.min(b1, p);
            s1 = Math.max(s1, p - b1);
            b2 = Math.min(b2, p - s1);
            s2 = Math.max(s2, p - b2);
        }
        return s2;        
    }
    public static void main(String[] args) {
        int prices[] = {10,22,5,75,65,80};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}

// Question: Coin Change (Minimum Coins)... 
// You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.
// Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

// Examples:
// Input: coins[] = [25, 10, 5], sum = 30
// Output: 2
// Explanation: Minimum 2 coins needed, 25 and 5.

package shreyam.gfg;

public class CoinChangeMinimumCoins {

    static int minCoins(int coins[], int sum) {
        int n = coins.length;

        int prev[] = new int[sum + 1];
        int cur[] = new int[sum + 1];

        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= sum; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);

                if (coins[ind] <= target)
                    take = 1 + cur[target - coins[ind]];

                cur[target] = Math.min(notTake, take);
            }

            prev = cur.clone();
        }

        int ans = prev[sum];

        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }


    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        int sum = 30;

        int res = minCoins(coins, sum);
        System.out.println(res);
        
    }
    
}

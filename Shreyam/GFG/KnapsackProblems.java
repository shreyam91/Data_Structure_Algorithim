// Question: 0-1 Knapsack Problem... 
// Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 
// Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

// Examples :
// Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
// Output: 3

package shreyam.gfg;

public class KnapsackProblems {
    static int solve(int capacity, int[]val, int[]wt, int index, int[][] dp){
        if(index ==0){
            if(wt[0] <= capacity){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }
        int include = 0;
        if(wt[index]<=capacity){
            include = val[index]+solve(capacity-wt[index],val,wt,index-1,dp);
        }

        int exclude = solve(capacity, val, wt, index-1, dp);

        return dp[index][capacity] = Math.max(include, exclude);
    }
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int [val.length][W+1];
        for(int i=0; i<val.length;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j] = -1;
            }
        }
            return solve(W, val, wt, val.length-1, dp);
        
    }
    public static void main(String[] args) {
       int W = 4;
       int val[] = {1, 2, 3};
       int wt[] = {4, 5, 1};
       
       int res = knapsack(W, val, wt);
       System.out.println(res);
    }
}

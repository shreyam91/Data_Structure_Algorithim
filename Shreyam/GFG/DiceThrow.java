// Qyestion: Dice throw 
// Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on each face when all the dice are thrown.

// Example:

// Input: m = 6, n = 3, x = 12
// Output: 25

package shreyam.gfg;

public class DiceThrow {
    static int solve(int m, int n, int x, int dp[][]){
        if(n==0 && x==0) return 1; 
        
        if(n==0) return 0;
        
        if(dp[n][x]!= -1) return dp[n][x];
        
        int ans = 0;
        
        for(int j=1; j<=m; j++){
            if(x-j >=0) ans+=solve(m, n-1, x-j, dp);
        }
        
        return dp[n][x] = ans;
    }
    static int noOfWays(int m, int n, int x) {
        // code here
        
        if(n*m <x) return 0;
        
        int dp[][] = new int[n+1][x+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=x; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(m, n, x, dp);
    }
    public static void main(String[] args) {
       int m = 6, n = 3, x = 12;
       System.out.println(noOfWays(m, n, x));
    }
}
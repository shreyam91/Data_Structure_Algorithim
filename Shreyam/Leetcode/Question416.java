// Question: Partition Equal Subset Sum... 
// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

// Example 1:
// Input: nums = [1,5,11,5]
// Output: true

package shreyam.leetCode;

public class Question416 {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;++i)
            sum += nums[i];
        
        if(sum%2 == 1)
            return false;
        
        boolean[][] dp = new boolean[n+1][sum/2+1];
        
        for(int i=0;i<=n;++i)
        for(int j=0;j<=sum/2;++j)
        {
            if(i==0 || j==0)    //Base Case
                dp[i][j] = false;
            else if(nums[i-1] > j)    //SkIP case
                dp[i][j] = dp[i-1][j];
            else if(nums[i-1]==j)
                dp[i][j] = true;
            else
                dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
        }        
        return dp[n][sum/2];
        
    }
    public static void main(String[] args) {
        int nums[] = {1,5,11,5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}

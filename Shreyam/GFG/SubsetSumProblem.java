// Question: Subset Sum Problem... 
// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

// Examples:
// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
// Output: true

package shreyam.gfg;

public class SubsetSumProblem {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Boolean dp[][]=new Boolean[n][sum+1];
        return rec(n-1,arr,sum,dp);
    }
    private static Boolean rec(int id,int arr[],int sum,Boolean dp[][]){
        if(sum==0) return true;
        if(id<0 || sum<0) return false;
        if(dp[id][sum]!=null) return dp[id][sum];
        Boolean p=rec(id-1,arr,sum-arr[id],dp);
        Boolean np=rec(id-1,arr,sum,dp);
        return dp[id][sum]=p || np;
    }
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean res = isSubsetSum(arr, sum);
        System.out.println(res);
    }
}

// Question: Cutting Binary String 

// You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this string into the minimum number of non-empty substrings such that:
// Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
// No substring should have leading zeros.
// Return the minimum number of such pieces the string can be divided into.
// Note: If it is not possible to split the string in this way, return -1.

// Examples:
// Input: s = "101101101"
// Output: 3

package shreyam.gfg;

public class CuttingBinaryString{
    static Integer [] dp;
    public static int cuts(String s) {
   
      dp =new Integer[s.length()+1];
       int ans=dfs(s,0);
        return ans==1000?-1:ans;
    }
    public static int dfs(String s,int idx)
    {
        if(idx>=s.length()) return 0;
        if(dp[idx]!=null) return dp[idx];
        int ans=1000;
        
        for(int i=idx+1;i<=s.length();i++)
        {
            if(isValid(s.substring(idx,i)))
            {
                ans=Math.min(ans,1+dfs(s,i));
            }
        }
        return dp[idx]=ans;
        
    }
    public static boolean isValid(String s)
    {
        int number=Integer.parseInt(s,2);
        if(s.charAt(0)=='0') return false;

        while(number>1)
        {
            if(number%5!=0) return false;
            number/=5;
        }
        return true;
    }
    public static void main(String[] args) {
       String s = "101101101" ;
        System.out.println(isValid(s));
    }
}
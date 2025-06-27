// Question: Mobile numeric keypad

// There is a standard numeric keypad on a mobile phone. You can press the current button or any button that is directly above, below, to the left, or to the right of it. For example, if you press 5, then pressing 2, 4, 6, or 8 is allowed. However, diagonal movements and pressing the bottom row corner buttons (* and #) are not allowed.
// Given an integer n, determine how many unique sequences of length n can be formed by pressing buttons on the keypad, starting from any digit.

// Examples :
// Input: n = 1
// Output: 10

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class MobileNumericKeypad {
    public static int getCount(int n) {
        int dialPad[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans+=rec(i,j,dialPad,n,new HashMap<>());
            }
        }
        return ans;
    }
    private static int rec(int i,int j,int dial[][],int n,Map<String,Integer> hm){
        if(i<0 || j<0 || i==4 || j==3 || dial[i][j]==-1) return 0;
        String key=i+" "+j+" "+n;
        if(hm.containsKey(key)) return hm.get(key);
        int curr=0;
        if(n==1) return 1;
        curr+=rec(i,j,dial,n-1,hm);
        curr+=rec(i-1,j,dial,n-1,hm);
        curr+=rec(i+1,j,dial,n-1,hm);
        curr+=rec(i,j+1,dial,n-1,hm);
        curr+=rec(i,j-1,dial,n-1,hm);
        hm.put(key,curr);
        return curr;
    }
    public static void main(String[] args) {
        int n =1;
        System.out.println(getCount(n));
    }
}

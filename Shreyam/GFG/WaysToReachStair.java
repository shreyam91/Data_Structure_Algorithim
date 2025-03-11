// Question: Ways to Reach the n'th Stair... 
// There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).

// Examples:
// Input: n = 1
// Output: 1
// Explanation: There is only one way to climb 1 stair. 

package shreyam.gfg;

public class WaysToReachStair {
    static int countWays(int n) {
        if (n<= 1) return 1;

        int a =1, b=1, temp;

        for(int i=2;i<=n;i++){
            temp = (a+b);
            a =b;
            b = temp;
        }
            return b;        
    }
    public static void main(String[] args) {
        int n =1;
        int res = countWays(n);
        System.out.println(res);
    }
}

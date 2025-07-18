// Question: LCM Triplet

// Given a number n. Find the maximum possible LCM that can be obtained by selecting three numbers less than or equal to n.
// Note : LCM stands for Lowest Common Multiple.

// Examples:
// Input: n = 9
// Output: 504

package shreyam.gfg;

public class LCMTriplet {
    static int lcmTriplets(int n) {
        
        long res = 0;
        if(n<3) return n;
        
        if(n%2 ==1){
            res = 1L *n *(n-1) *(n-2);
        }
        
        else if(n%3 != 0){
            res = 1L *n *(n-1)*(n-3);
        }
        else{
            res = 1L * (n-1) * (n-2) *(n-3);
        }
        
        return (int) res;
    }
    public static void main(String[] args) {
        int n =9;
        System.out.println(lcmTriplets(n));
    }
}

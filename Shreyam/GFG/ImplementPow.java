// Question: Implement Pow.... 
// Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

// Examples:
// Input: b = 3.00000, e = 5
// Output: 243.00000

package Shreyam.gfg;

public class ImplementPow {
    static double power(double b, int e) {
        if(e<0){
            return 1/power(b,-e);
        }
        if(e==1){
            return b;
        }
        if(e==0)
        return 1;
        double halfPow = power(b, e/2);
        if(e%2==0){
            return halfPow*halfPow;
        }
        return b*halfPow*halfPow;
    }
    public static void main(String[] args) {
        double b = 3.0000;
        int e = 5;
        double res = power(b, e);
        System.out.println(res);
    }
}

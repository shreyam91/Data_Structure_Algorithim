// Question: Trail of ones

// Given an integer n, the task is to count the number of binary strings of length n that contains at least one pair of consecutive 1's.
// Note: A binary string is a sequence made up of only 0's and 1's.

// Examples:
// Input: n = 2
// Output: 1


package shreyam.gfg;

public class TrailOfOnes {
    public static int fibonacci(int n){
        if(n==0) return 0;
        else if(n==2 || n==1){
            return 1;
        }
        else return (fibonacci(n-1)+fibonacci(n-2));
    }
    public int countConsec(int n) {
        int pre=1<<n;
        return (pre-fibonacci(n+2));
    }
    public static void main(String[] args) {
        int n =2;
        System.out.println(fibonacci(n));
    }
}

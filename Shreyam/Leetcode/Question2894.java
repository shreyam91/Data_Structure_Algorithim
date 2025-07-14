// Question: Divisible and Non- divisible Sums Difference 

// You are given positive integers n and m.
// Define two integers as follows:
// num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
// num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
// Return the integer num1 - num2.

// Example 1:
// Input: n = 10, m = 3
// Output: 19

package shreyam.leetcode; 

public class Question2894 {
    public static int differenceOfSums(int n, int m) {
        int oddSum = 0;
        int evenSum = 0;
        for( int i=1; i<=n;i++){
            if(i % m == 0){
                oddSum += i;
            }else{
                evenSum += i;
            }
        }
        int difference = evenSum - oddSum;
        return difference;
    }

    public static void main(String[] args) {
        int n = 10, m = 3;
        System.out.println(differenceOfSums(n, m));
    }
}

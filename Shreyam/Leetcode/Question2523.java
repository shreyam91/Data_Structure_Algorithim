// Question: Closet Prime Number in Range... 
// Given two positive integers left and right, find the two integers num1 and num2 such that:
// left <= num1 < num2 <= right .
// Both num1 and num2 are prime numbers.
// num2 - num1 is the minimum amongst all other pairs satisfying the above conditions. Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

// Example 1:
// Input: left = 10, right = 19
// Output: [11,13]
// Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
// The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
// Since 11 is smaller than 17, we return the first pair.

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2523 {
    public static int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime,true);

        for(int i=2; i*i <= right; i++){
            if(isPrime[i]){
                for(int j=2*i; j<= right; j+= i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=Math.max(2, left); i<= right; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        int a =0, b= Integer.MAX_VALUE;
        for(int i=1; i<primes.size();i++){
            if(b-a > primes.get(i) - primes.get(i-1)){
                b = primes.get(i);
                a = primes.get(i-1);
            }
        }

        if(a == 0){
            return new int[] {-1,-1};
        }else{
            return new int[] {a,b};
        }
        
    }
    public static void main(String[] args) {
        int left =10, right = 19;
        int[] res = closestPrimes(left, right);
        for(int ele : res){
            System.out.print(ele + " ");
        }

    }
}

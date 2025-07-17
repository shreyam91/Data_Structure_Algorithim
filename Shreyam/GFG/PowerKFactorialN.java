// Question: Power of k in factorial of n 

// Given two positive integers n and k, determine the highest value of x such that kx divides n! (n factorial) completely (i.e., n % (kx) == 0).

// Examples :
// Input: n = 7, k = 2
// Output: 4

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class PowerKFactorialN{
    public static int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        int num = k;
        for (int i = 2; i * i <= num; i++) {
            while (k % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            primeFactors.put(k, 1);
        }

        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int powerInK = entry.getValue();
            
            int count = 0;
            int tempN = n;

            while (tempN > 0) {
                count += tempN / prime;
                tempN /= prime;
            }

            result = Math.min(result, count / powerInK);
        }

        return result;
    }
    public static void main(String[] args) {
        int n =7, k=2;
        System.out.println(maxKPower(n, k));
    }
}
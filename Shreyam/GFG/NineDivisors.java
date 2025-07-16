// Question: Nine Divisors 
// Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.

// Examples :
// Input: n = 100
// Output: 2

package shreyam.gfg;

public class NineDivisors {
    public static int countNumbers(int n) {
    int count = 0;

    int limit = (int) Math.sqrt(n) + 1;
    boolean[] isPrime = new boolean[limit + 1];
    for (int i = 2; i <= limit; i++) isPrime[i] = true;

    for (int i = 2; i * i <= limit; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= limit; j += i) {
                isPrime[j] = false;
            }
        }
    }

    java.util.List<Integer> primes = new java.util.ArrayList<>();
    for (int i = 2; i <= limit; i++) {
        if (isPrime[i]) primes.add(i);
    }

    for (int p : primes) {
        long num = 1;
        for (int i = 0; i < 8; i++) num *= p;
        if (num <= n) count++;
        else break;
    }

    int size = primes.size();
    for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
            long num = 1L * primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j);
            if (num <= n) count++;
            else break;
        }
    }

    return count;
}

    public static void main(String[] args) {
        int n =100;
        System.out.println(countNumbers(n));
    }
}

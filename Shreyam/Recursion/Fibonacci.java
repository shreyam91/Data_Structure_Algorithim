package Shreyam.Recursion;

// public class Fibonacci {
//     public static int fibonacci(int n){
//         if( n<=1) return n;
//         return fibonacci(n-1) + fibonacci(n-2);
//     }
//     public static void main(String[] args) {
//         int n =10;
//         System.out.println("Fibonacci of" + n + "is:" + fibonacci(n));
//     }
// }


import java.util.HashMap;

public class Fibonacci {
    
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        
        return result;
    }
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
package Misha;

import java.math.BigInteger;

public class FactorialLargeNo {
    public static void main(String[] args) {
        BigInteger factorial = BigInteger.ONE;
    int n=50;
for(int i=1;i<=n;i++){
    factorial=factorial.multiply(BigInteger.valueOf(i));
}
System.out.println("factorial of 50 is " + factorial);
}

}

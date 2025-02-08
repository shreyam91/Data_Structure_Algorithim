package Shreyam.recursion;

public class BasicTwo {
    static void ParameterisedRecursion(int i, int sum){
        if(i<1){
            System.out.println("Parameterised Recursion sum:" + sum);
            return;
        }
        ParameterisedRecursion(i-1, sum+i);
    }

    static int FunctionalRecusrsion(int i){
        if(i==0) return 0;
        return i + FunctionalRecusrsion(i-1);
    }
    public static void main(String[] args) {
        ParameterisedRecursion(5, 0);
        int res = FunctionalRecusrsion(6);
        System.out.println("Functional Recursion sum:" + res);
    }
}

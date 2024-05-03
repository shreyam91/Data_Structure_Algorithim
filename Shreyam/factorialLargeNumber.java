package Shreyam;

public class factorialLargeNumber {
    public static void main(String[] args) {
        System.out.println("Find the factorial of a large number in the gievn array...");

        int arr [] = {1, 2, 3, 4, 5, 6, 7, 8};
        int max = 0;
        int factorial = 1;
        int i =0;

        for (i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum "+ max);

        for (i = 1; i <= max; i++) {
            factorial *= i;
        }
        System.out.println("Factorial "+ factorial);
    }
    
}

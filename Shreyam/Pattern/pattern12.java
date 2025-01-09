package Shreyam.Pattern;

public class pattern12 {
    public static void main(String[] args) {
        int n = 4;  // Adjust for n = 4
        
        for (int i = 1; i <= n; i++) {
            if (i == 3) {
                System.out.print("* ");
                System.out.print("*");
            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println(); 
        }
        
        for (int i = n - 1; i >= 1; i--) {
            if (i == 3) {
                System.out.print("* ");
                System.out.print("*");
            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println(); 
        }
    }
    }



    // *
    // **
    // * *
    // ****
    // * *
    // **
    // *
package shreyam.pattern;

public class pattern12 {
    public static void main(String[] args) {
        int n = 5;  // Adjust for n = 4

            // <!-- Upper part -->
        // for (int i = 1; i <= (2*n)-1; i++) {
        //     if (i == 3) {
        //         System.out.print("* ");
        //         System.out.print("*");
        //     } else {
        //         for (int j = 1; j <= i; j++) {
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.println(); 
        // }
            // <!-- Lower part -->
        // for (int i = (2*n) - 1; i >= 1; i--) {
        //     if (i == 3) {
        //         System.out.print("* ");
        //         System.out.print("*");
        //     } else {
        //         for (int j = 1; j <= i; j++) {
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.println(); 
        // }

        // Upper part of the arrow
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println("*");
            } else if (i == n) {
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                System.out.print("*");
                for (int j = 1; j < i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }

        // Lower part of the arrow
        for (int i = n - 1; i >= 1; i--) {
            if (i == 1) {
                System.out.println("*");
            } else {
                System.out.print("*");
                for (int j = 1; j < i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }
    }


package Shreyam.pattern;

public class pattern_reverse {
    public static void main(String[] args) {
        int rows = 4; 
        int stars = 1; 

        for (int i = 0; i <= rows; i++) {
            int numberOfStars = stars+2*i;
            int spaces = rows-i;
            // int spaces = (stars + numberOfStars) * 2;

            for (int j = 0; j <= spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <numberOfStars; j++) {
                System.out.print("*");
                // System.out.print(" ");
            }

            System.out.println();
        }
    }
}


package Java;

public class pattern {
    public static void main(String[] args) {
        int rows = 5; // Number of rows you want to print
        int stars = 9; // Starting number of stars

        for (int i = 0; i < rows; i++) {
            // Calculate the number of stars and spaces
            int numberOfStars = stars - 2 * i;
            int spaces = (stars - numberOfStars) / 2;

            if (numberOfStars <= 0) {
                break;
            }

            // Print leading spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print("*");
            }

            // Move to the next line
            System.out.println();
        }
    }
}


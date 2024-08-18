package Java;

public class pattern {
    public static void main(String[] args) {
        int rows = 5;
        int stars = 9; 

        for (int i = 0; i < rows; i++) {
            int numberOfStars = stars - 2 * i;
            int spaces = (stars - numberOfStars) / 2;

            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < numberOfStars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}


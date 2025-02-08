package Shreyam.string;

import java.lang.Character;


public class StringMultiplication {
    public static void main(String[] args) {
        String input = "a1b2c3d9";
        String result = expandString(input);
        System.out.println(result);
    }
    
    public static String expandString(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < input.length()) {
            char letter = input.charAt(i);
            i++;
            
            // Collect the full number following the letter
            StringBuilder numberBuilder = new StringBuilder();
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                numberBuilder.append(input.charAt(i));
                i++;
            }
            
            int repeatCount = Integer.parseInt(numberBuilder.toString());
            
            // Append the letter repeatCount times
            for (int j = 0; j < repeatCount; j++) {
                result.append(letter);
            }
        }
        
        return result.toString();
    }
}
package Shreyam;

public class ReverseString {
    public static void main(String[] args) {
        
        String original = "Data Structure";
        String reverse = new StringBuilder(original).reverse().toString();

        System.out.println("Original string: " + original);
        System.out.println("Reverse string: " + reverse);
    }
    
}

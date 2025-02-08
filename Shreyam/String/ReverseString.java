package Shreyam.string;

public class ReverseString {
    public static void main(String[] args) {
        
        String original = "Data Structure";
        String reverse = new StringBuilder(original).reverse().toString();

        System.out.println("Original string: " + original);
        System.out.println("Reverse string: " + reverse);
    }
    
}


// `StringBuilder` in Java is like a mutable sequence of characters. Ut allows you to efficinently modify strings without creating new instances of strings every time you make a change...

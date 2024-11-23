package Shreyam.Recursion;

public class Palindrome {
    static Boolean checkPalindrome(String s,int i){
        if(i>= s.length()/2) return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;        return checkPalindrome(s, i+1);
    }

    public static void main(String[] args) {
        String s = "MADAM";
        boolean result = checkPalindrome(s, 0); 
        if (result) {
            System.out.println(s + " is a palindrome.");
        } else {
            System.out.println(s + " is not a palindrome.");
        }
    }
}

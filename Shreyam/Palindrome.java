package Shreyam;

public class Palindrome {
    public static void main(String[] args) {
        String s1 = "madam";
        String s2 = "";

        for(int i=0; i<s1.length();i++){
            char ch = s1.charAt(i);
            s2 = s2+ ch;
        }
        System.out.println(s2);
        System.out.println("is palindrome or not: " + s1.equals(s2));
    }
}

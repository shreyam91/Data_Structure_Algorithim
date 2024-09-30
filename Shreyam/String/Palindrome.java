package Shreyam.String;

public class Palindrome {
    public static void main(String[] args) {
        // String s1 = "rahul";
        // String s2 = "";

        // for(int i=0; i<s1.length();i--){
        //     char ch = s1.charAt(i);
        //     s2 = s2+ ch;
        // }
        // System.out.println(s2);
        // System.out.println("is palindrome or not: " + s1.equals(s2));

        // boolean result = true;
        // int length = s1.length();

        // for(int i=0;i<length/2;i++){
        //     if(s1.charAt(i) != s1.charAt(length-i-1)){
        //         result = false;
        //         break;
        //     }
        // }
        // return result;

        // String str = "naman";
        // StringBuilder str1 = new StringBuilder(str);

        // // str1.reverse();
        // if(str.equals(str1.reverse().toString())){
        //     System.out.println("palinfrome");
        // }else{
        //     System.out.println("not");
        // }


        String str = "Madam";
        StringBuilder str1 = new StringBuilder(str);

        if(str.equalsIgnoreCase(str1.reverse().toString()))
        { 
            System.out.println("palindrome");
        }
        else{
            System.out.println("Not a palindrome");
            }

    }
}

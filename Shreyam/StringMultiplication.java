package Shreyam;

public class StringMultiplication {
    public static void main(String[] args) {
        System.out.println("This program is to print string multiplication.....");

        String s = "a1b3";
        String sb= "";
        int num =0;

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);

            if(i<s.length() && Character.isDigit(s.charAt(i))){
                num =num*10 + (s.charAt(i) - '0');
            }
            sb = c + num;
        }

        System.out.println(sb);


    }

}

package Shreyam;
import java.util.Scanner;

public class Character {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        

        String st = scanner.nextLine();
        String[] sm = st.split(" ");
        
        for(String sms:sm){
            System.out.println(sms.charAt(0));
        }

        scanner.close();
        //     char ch = st.charAt(0);
        // int count =0;

        // System.out.println(st.charAt(0)); //M
        // System.out.println(st.charAt(6)); //S

        // for(int i=0;i<sm.length;i++){
            // char ch = st.charAt(0);
            // System.out.println(ch);

            // char ch = st.charAt(0);
            // count ++;
            // System.out.println(ch);

            // if(ch == ' '){
            //     count =0;
            // }
            // System.out.println(ch);

        // }

        // String s1 = "Misha";
        // String s2 = "Shambhavi";

        // String max = 

        // for(int i=0;i<s2.length();i++){
        //     System.out.println(s1.charAt(0));
        //     System.out.println(s2.charAt(0));
        //     if(i==0){
        //         break;
        //     }
        // }

        // String sr = "Misha Shambhavi";
        
    //     for(int i=0;i<sr.length();i++){
    //         // char ch = sr.charAt(i);
    //         char ch = sr.charAt(i);
    //         System.out.println(ch);

    //         if (Character.isUpperCase(ch)){
    //             // System.out.println(ch);
    //             System.out.println("upper case");
    //         }else{
    //             System.out.println("lower");
    //         }
    //         // if(ch == ' '){
    //         //     break;
    //         //     continue;
    //         // }

    //     }

    // for(int i=0; i<sr.length();i++){
    //     char val = sr.charAt(i);
    //     System.out.println("Character: "+val);

        
  
        // if (Character.isUpperCase(val)) {
        //    System.out.println("Character is in Uppercase!");
        // }else {
        //    System.out.println("Character is in Lowercase!");
        //   //  break;
        // }
        // }

    }

    public static boolean isDigit(char c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDigit'");
    }

    
}

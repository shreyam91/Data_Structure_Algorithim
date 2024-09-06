package Shreyam;

public class StringLearning {
    public static void main(String[] args) {

            // String 
        String sr = new String ("Java");
        sr.concat("software");
        // System.out.println(sr); //Java

        String s = "React";
        String sp = "React";
        // System.out.println(s == sp); // true


        String s1 = new String("Java");
        String s2 = new String("Java");
        // System.out.println(s1==s2); // false because it only compare reference of object (it returns true if both reference point to only one object)
        // System.out.println(s1.equals(s2)); // true it compares content 


            // String Buffer 
        StringBuffer sb = new StringBuffer("Raman");
        // sb.append("software");
        // System.out.println(sb); //JavaSoftware

        StringBuffer sb1 = new StringBuffer("Java");
        StringBuffer sb2 = new StringBuffer("Java");
        // System.out.println(sb1 == sb2); // false
        // System.out.println(sb1.equals(sb2)); // false

        // System.out.println(sb2.capacity()); // string buffer capacity (16) + string length 
        // System.out.println(sb.charAt(30)); // String Index bound of Exception (there is no string buffer index of bound)
        // sb.setCharAt(0, 'N');
        sb.reverse();
        System.out.println(sb);



    }
}

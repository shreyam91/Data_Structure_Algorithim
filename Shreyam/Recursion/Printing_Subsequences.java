package Shreyam.Recursion;

public class Printing_Subsequences {

                    // <---- String ----->
    // static void Subsequences(String str, String subsequence, int index){
    //     if(index == str.length()){
    //         System.out.println(subsequence);
    //         return;
    //     }
    // Subsequences(str, subsequence, index+1); // Exclude the character at 'index'
    // Subsequences(str, subsequence + str.charAt(index), index+1);  //Include the character at 'index'

                // <---- Number ----->
        static void Subsequences(int num , String subsequence, int index){
        if(index == String.valueOf(num).length()){
            System.out.println(subsequence);
            return;
        }
        Subsequences(num, subsequence, index + 1);
        Subsequences(num, subsequence + String.valueOf(String.valueOf(num).charAt(index)), index + 1);

    }
    public static void main(String[] args) {
        // String str = "abc";
        // System.out.println("All subsequence of" + str + ":");
        // Subsequences(str, "", 0);

        int num = 123;  // Example number
        System.out.println("All subsequences of " + num + ":");
        Subsequences(num, "", 0);
    }
}

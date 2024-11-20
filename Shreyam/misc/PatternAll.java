package Shreyam.misc;

import java.util.Scanner;

public class PatternAll {
    static void print1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // ****
        // ****
        // ****
        // ****
    }

    static void print2(int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // * * * * *  
        // * * * *  
        // * * *  
        // * *  
        // *
    }

    static void print3(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
            // *  
            // * *  
            // * * *  
            // * * * * 
    }

    static void print4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println(" ");
        }
            // 1  
            // 1 2 
            // 1 2 3   
            // 1 2 3 4  
    }

    static void print5(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println(" ");
        }
            // 1  
            // 2 2 
            // 3 3 3   
            // 4 4 4 4   
    }
    
    static void print6(int n){
        for(int i=0;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(j);
            }
            System.out.println(" ");
        }
        // 12345 
        // 1234 
        // 123 
        // 12 
        // 1 
    }
    
    static void print7(int n){
        int star = 1;
        for(int i=0;i<n;i++){
            int numberOfStars = star+2*i;
            int spaces = n-i;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }

            for (int j = 0; j <numberOfStars; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
            //      * 
            //     *** 
            //    ***** 
            //   ******* 
    }
    
    static void print8(int n){
        int star = 9;
        for(int i=0;i<n;i++){
            int numberOfStars = star-2*i;
            int spaces = (star - numberOfStars) / 2;
            for(int j=0;j<=spaces;j++){
                System.out.print(" ");
            }

            for (int j = 0; j <numberOfStars; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
            // ********* 
            // ******* 
            //  ***** 
            //   *** 
            //    * 
    }

    static void print9(int n) {
        for (int i = 0; i < n; i++) {
            int numberOfStars = 1 + 2 * i;   
            int spaces = n - i;              
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    
        for (int i = 0; i < n; i++) {
            int numberOfStars = 2 * n - 1 - 2 * i;  
            int spaces = (2 * n - 1 - numberOfStars) / 2;  
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static  void print10(int n){
        for(int i=1;i<= 2*n-1;i++){
            int stars = i;
            if(i>n)
                stars = 2*n-i;
            for(int j=1;j<=stars;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    static void print11(int n){
        int start = 1;
        for(int i=0;i<n;i++){
            if(i%2 == 0) start = 1;
            else start=0;
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start = 1-start;
            }
            System.out.println();
        }
    }

    static void print12(int n){
        int space = 2*(n-1);
        for(int i=1;i<=n;i++){
            //numbers
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            //space
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }
            //numbers
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
            space -= 2;
        }
    }

    static void print13(int n){
        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num + " ");
                num = num+1;
            }
            System.out.println();
        }
    }

    static void print14(int n){
    //    char ch = 'A';
        for(int i=0;i<n;i++){
            // for(int j=1;j<=i;j++){
            //     System.out.print(ch);
            //     ch = (char) (ch+1);
            // }
            for(char ch ='A'; ch<='A' +i;ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    static void print15(int n){
        for(int i=0;i<n;i++){
            for(char ch='A'; ch<='A' + (n-i-1);ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void print16(int n){
        for(int i=0;i<n;i++){
            char ch = (char) ('A' + i);
            for(int j=0;j<=i;j++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void print17(int n){

    }
    public static void main(String[] args) {
        System.out.print("Enter number only:");
        Scanner numberPattern = new Scanner(System.in);
        int number = numberPattern.nextInt();

        // print1(number); 
        // print2(number);
        // print3(number);
        // print4(number);
        // print5(number);
        // print6(number);
        // print7(number);
        // print8(number);
        // print9(number);
        // print10(number);
        // print11(number);
        // print12(number);
        // print13(number);
        // print14(number);
        // print15(number);
        // print16(number);
        print17(number);
    }
}

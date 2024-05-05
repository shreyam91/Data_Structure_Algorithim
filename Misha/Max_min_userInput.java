package Misha;



import java.util.Scanner;

public class Max_min_userInput {
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    System.out.println( "enter arrary length ");
    int num = sc.nextInt();
    int arr[] = new int[num];
    int min = arr[0];
    int max= arr[0];

    System.out.println("input numbers");
    for(int i=0;i<=arr.length-1;i++){
        arr[i]=sc.nextInt();
        
        if(arr[i]<min){
            min=arr[i];
        }
        else if(arr[i]>max){
            max=arr[i];
        }
    }
    System.out.println("maximum  is " + max );
    System.out.println("Minimum is " + min );
    sc.close();

    
}


}


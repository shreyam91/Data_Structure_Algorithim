package Misha;

public class Reverse_array_1 {
   public static void main(String[] args) {
    int arr[] = new int[] {2,7,4,1,9};
    
    System.out.println("Given input");
    for ( int i=0 ; i < arr.length ; i++) {
    System.out.println(" " + arr[ i ]);
   } 

System.out.println("Reversed array");
for(int i=arr.length-1 ; i >= 0; i--){
    System.out.println(" " + arr[i]);   

}
}
}

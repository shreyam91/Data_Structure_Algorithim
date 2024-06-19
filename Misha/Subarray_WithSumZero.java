package Misha;

public class Subarray_WithSumZero {
    
   
    public static boolean subArrayexists(int arr[]){
        for(int i=0;i<arr.length;i++){
            int curr_sum=0;
            for(int j=i+1;j<arr.length;j++){
            curr_sum = curr_sum + arr[j];
            if(curr_sum ==0)
            return true;
            }
        }
        return false;
    }

 public static void main(String[] args) {
    int arr[] = new int[]{-3,2,0,1,6};
    
   if(subArrayexists(arr))
    System.out.println("Found array with 0 sum");
   
   else
    System.out.println("No such array exists");
   
 }   
}



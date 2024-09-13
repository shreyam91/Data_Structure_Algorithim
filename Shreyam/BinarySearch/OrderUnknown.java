package Shreyam.BinarySearch;

public class OrderUnknown {
    public static int orderUnknown(int []arr, int target){
        // int start =0, end = arr.length-1;
        

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,12,45,89};
        int target = 12;

        int Result = orderUnknown(arr, target);

        if(Result == -1){
            System.out.println("Element not present...");
        }else{
            System.out.println("Element present at index:" + Result);
        }
    }

}

package Shreyam.BinarySearch;

public class ReverseSortedArray {

    public static int RevresedArray(int arr[], int target){
        int start =0, end= arr.length-1;

        while(start<= end){
            int mid = start + (start+end)/2;
            if(target == arr[mid])
                return mid;
            
                else if(arr[mid] > target){
                    start = mid-1;
                    
                }
                else{
                    end = mid-1;
                }
        }

        return -1;
        
    }
    public static void main(String[] args) {
        int [] arr = {34,23,19,16,12,9,5,2};
        int key =5;
        int result  = RevresedArray(arr, key);

        if(result == -1){
            System.out.println("Elmement not present..");
        }
        else{
            System.out.println("Element found at index:" + result);
        }
    }
}

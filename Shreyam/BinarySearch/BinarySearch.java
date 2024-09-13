package Shreyam.BinarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start =0, end = arr.length-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid])
                return mid;
            
                else if(arr[mid] < target){
                    end = mid+1;
                }
                else{
                    end = mid-1;
                }
            
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {2,4,6,8,9,13,34};
        int key =8;
        int result  = binarySearch(arr, key);

        if(result == -1){
            System.out.println("Elmement not present..");
        }
        else{
            System.out.println("Element found at index:" + result);
        }
    }
    
}

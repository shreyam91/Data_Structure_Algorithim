// Find a element in a Rotated Array 
package Shreyam.BinarySearch;

public class ElementRotatedArray {

    public static int binarySearch(int[] arr,int target){
        int n = arr.length;
        int start =0, end =n-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            }
            if(arr[start] <= arr[mid]){
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(arr[mid] <= target && target <= arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {22,27,34,45,5,8,9,10};
        int target = 5;
        int Result= binarySearch(arr,target);

        if(Result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at:"+ Result + " index.");
        }
    }
    
}


package Shreyam.binarySearch;

public class ElementOccurance {
    public static int elementOccurance(int [] arr,int target){
        // int firstOccurance = -1;
        int lastOccuranece = -1;
        int start =0, end = arr.length-1;
        
        while(start <= end){
            int mid = start +(end-start)/2;

            if(arr[mid] == target){
                // firstOccurance = mid;
                // end =mid-1;
                lastOccuranece = mid;
                start = mid+1;
            }
            else if(target < arr[mid]){ 
                end = mid-1;
            }
            else{
                start = mid+1; 
            }

        }

        return lastOccuranece;
        
    }
    public static void main(String[] args) {
        int [] arr = {2,5,7,9,10,10,10,12,18};
        int key =10;

        int Result = elementOccurance(arr, key);
        if(Result == -1){
            System.out.println("Elements not found");
        }else{
            System.out.println("Elements are found at:" + Result);
        }

    }
}

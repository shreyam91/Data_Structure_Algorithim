// Find a element in a Rotated Array 
package Shreyam.BinarySearch;

public class ElementRotatedArray {
    public static int midElement(int[]arr){
        int start=0,end =arr.length-1;
        int N = arr.length;

        while(start <= end){
            int mid = start + (end-start)/2;
            int prev = (mid + N-1);
            int next = (mid-1);

            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                return mid;
            }else if(arr[mid] <= arr[start]){
                start = mid+1;
            }
            else{
                end =mid-1;
            }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        int[] arr = {34,45,56,67,9,11,16,23};
        int target = 16;

    }
    
}


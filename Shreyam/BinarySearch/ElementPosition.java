package Shreyam.BinarySearch;

// find position of an element in an Infinite Sorted Array....
public class ElementPosition {
    public static int findPosition(int[]arr, int target){
        int start =0,end=1;

        while(end < arr.length && arr[end] < target){
            start = end;
            end = Math.min(end * 2, arr.length - 1);

        }
        return binarySearch(arr, start, end, target);
    }

    public static int binarySearch(int[] arr, int start,int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            }

            else if(arr[mid] <= target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {2,3,4,5,6,7,8,9,11,13,15};
        int target = 9;

        int Result = findPosition(arr, target);

        if(Result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: "+ Result);
        }
    }
    
}

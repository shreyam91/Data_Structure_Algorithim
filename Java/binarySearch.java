package Java;

public class binarySearch {
    
    public static int binarySearch(int[]arr, int target){
        int start = 0,end = arr.length-1;
        // int mid = (start+end)/2;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {3,12,34,56,67,89};
        int target = 34;

        int result = binarySearch(arr, target);

        System.out.println("At index" + result);
    }
    
}

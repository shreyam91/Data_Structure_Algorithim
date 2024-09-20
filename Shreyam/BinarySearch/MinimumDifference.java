package Shreyam.BinarySearch;

public class MinimumDifference {
    public static int binarySearch(int [] arr, int target){
        int start =0, end=arr.length-1;
        int minDifference = arr[0];

        while(start <= end){
            int mid = start + (end-start)/2;

            if (Math.abs(arr[mid] - target) < Math.abs(minDifference - target)) {
                minDifference = arr[mid];
            }

            if(arr[mid] == target)
                return mid;
            
            else if(arr[mid] <= target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return minDifference;
    }
    public static void main(String[] args) {
        int[] arr = {9,12,15,17,19,21};
        int target = 16;
        int Result = binarySearch(arr, target);

        if(Result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Minimum Difference element is: "+ Result);
        }

    }
}

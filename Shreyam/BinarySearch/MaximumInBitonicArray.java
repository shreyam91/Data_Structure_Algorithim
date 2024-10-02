package Shreyam.BinarySearch;

public class MaximumInBitonicArray {
    public static int binarySearch(int[] arr){
        int start =0, end = arr.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if ((mid == start || arr[mid] > arr[mid - 1]) && (mid == end || arr[mid] > arr[mid + 1])) {
                return mid; 
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,10,15,20,10,3};

        int result = binarySearch(arr);

        if(result == -1)
            System.out.println("No element found");
        else
            System.out.println("Element found" + result + " " + arr[result]);
    }
}

package Shreyam.BinarySearch;

public class OrderUnknown {
    public static int orderUnknown(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        
        if (arr.length == 0) {
            return -1;
        }
        
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            
            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {9,12,24,35,67,89};
        int target = 42;

        int Result = orderUnknown(arr, target);

        if(Result == -1){
            System.out.println("Element not present...");
        }else{
            System.out.println("Element present at index:" + Result);
        }
    }

}

package Shreyam.binarySearch;

public class ElementInBitonicArray {
    public static int findBitonicMax(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == start || arr[mid] > arr[mid - 1]) && (mid == end || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }

        return -1; 
    }

    public static int binarySearchIncreasing(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; 
    }

    public static int binarySearchDecreasing(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1; 
            } else {
                end = mid - 1; 
            }
        }
        return -1; 
    }

    public static int searchInBitonicArray(int[] arr, int target) {
        int maxIndex = findBitonicMax(arr);

        int result = binarySearchIncreasing(arr, 0, maxIndex, target);
        if (result != -1) {
            return result;
        }

        return binarySearchDecreasing(arr, maxIndex + 1, arr.length - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,8,12,4,2};
        int key = 4;

        int result = searchInBitonicArray(arr, key);
        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at: "+ result);
    }
}

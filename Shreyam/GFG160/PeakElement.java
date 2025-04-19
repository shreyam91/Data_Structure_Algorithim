// Question: Peak element... 
// Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
// Note: Consider the element before the first element and the element after the last element to be negative infinity.

// Examples :
// Input: arr = [1, 2, 4, 5, 7, 8, 3]
// Output: true


package shreyam.GFG160;

public class PeakElement {
    public static int peakElement(int[] arr) {
        
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int left = (mid == 0) ? Integer.MIN_VALUE : arr[mid - 1];
            int right = (mid == arr.length - 1) ? Integer.MIN_VALUE : arr[mid + 1];

            if (arr[mid] > left && arr[mid] > right) {
                return mid;
            } else if (arr[mid] < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static boolean validatePeak(int[] arr, int index) {
        int left = (index == 0) ? Integer.MIN_VALUE : arr[index - 1];
        int right = (index == arr.length - 1) ? Integer.MIN_VALUE : arr[index + 1];

        return arr[index] > left && arr[index] > right;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};
        int res = peakElement(arr);
        System.out.println(validatePeak(arr, res));
    }
}

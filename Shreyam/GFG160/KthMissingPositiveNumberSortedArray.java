// Question: Kth Missing Positive Number in a Sorted Array... 
// Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

// Examples :
// Input: arr[] = [2, 3, 4, 7, 11], k = 5
// Output: 9


package shreyam.GFG160;

public class KthMissingPositiveNumberSortedArray {
    public static int findKthPositive(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int missing = arr[mid] - mid - 1;
            if (missing < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return k + s;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 7, 11}, k = 5;
        int res = findKthPositive(arr, k);
        System.out.println(res);
    }
}

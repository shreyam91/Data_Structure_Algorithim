// Question:Number of occurrence... 
// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

// Examples :
// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
// Output: 4


package shreyam.GFG160;

public class NumberOfOccurrence {

    public static int firstOcc(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                ans = mid;
                e = mid - 1; 
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOcc(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                ans = mid;
                s = mid + 1; 
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static int countFreq(int[] arr, int target) {
        int first = firstOcc(arr, target);
        int last = lastOcc(arr, target);
        if (first == -1 || last == -1) return 0;
        return last - first + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        int res = countFreq(arr, target);
        System.out.println(res);  
    }
}

// Question: K closest elements

// You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.
// An element a is closer to x than b if:
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)
// Return the k closest elements in order of closeness.

// Examples:
// Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
// Output: 3 1


package shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class KClosestElements {
   static int[] printKClosest(int[] arr, int k, int x) {
        int n   = arr.length;
        int pos = -1;

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                pos = mid; 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int left = pos, right = pos + 1;

        if (right < n && arr[right] == x) {
            right++;
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        while (left >= 0 && right < n && resultList.size() < k) {
            int leftDiff  = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);

            if (leftDiff < rightDiff) {
                resultList.add(arr[left]);
                left--;
            } else {
                resultList.add(arr[right]);
                right++;
            }
        }

        while (left >= 0 && resultList.size() < k) {
            resultList.add(arr[left]);
            left--;
        }

        while (right < n && resultList.size() < k) {
            resultList.add(arr[right]);
            right++;
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 10, 12};
        int k = 2, x = 4;
        System.out.println(Arrays.toString(printKClosest(arr, k, x)));
    }
}

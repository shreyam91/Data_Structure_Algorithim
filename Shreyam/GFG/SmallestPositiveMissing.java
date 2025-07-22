// Question: Smallest Positive Missing

// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
// Note: Positive number starts from 1. The array can have negative integers too.

// Examples:
// Input: arr[] = [2, -3, 4, 1, 1, 7]
// Output: 3


package shreyam.gfg;

public class SmallestPositiveMissing {
    public static int missingNumber(int[] arr) {
          int n = arr.length;

        boolean[] vis = new boolean[n];
        
        for (int i = 0; i < n; i++) {
           if (arr[i] > 0 && arr[i] <= n)  vis[arr[i] - 1] = true;
        }

    
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1]) {
                return i;
            }
        }

        return n + 1;
    }
    public static void main(String[] args) {
        int arr[] ={2, -3, 4, 1, 1,7};
        System.out.println(missingNumber(arr));
    }
}

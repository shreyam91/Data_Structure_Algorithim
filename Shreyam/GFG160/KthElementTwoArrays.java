// Question: K-th Element of Two Arrays.... 
// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

// Examples :
// Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
// Output: 6

package shreyam.GFG160;

public class KthElementTwoArrays {
    public static int kthElement(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length;

        if (k == n1 + n2) {
            return Math.max(arr1[n1 - 1], arr2[n2 - 1]);
        }

        if (k == 1) {
            return Math.min(arr1[0], arr2[0]);
        }

        int i = 0, j = 0;
        while (i < n1 && j < n2 && k > 1) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
            k--;
        }

        while (i < n1 && k > 1) {
            i++;
            k--;
        }

        while (j < n2 && k > 1) {
            j++;
            k--;
        }

        if (i == n1) return arr2[j];
        else if (j == n2) return arr1[i];
        return Math.min(arr1[i], arr2[j]);
    }
    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7, 9}; 
        int b[] = {1, 4, 8, 10};
        int k = 5;

        int res = kthElement(a, b, k);
        System.out.println(res);

    }
}

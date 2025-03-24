// Question: Next Permutation... 
// Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 
// Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

// Examples:
// Input: arr = [2, 4, 1, 7, 5, 0]
// Output: [2, 4, 5, 0, 1, 7]

package shreyam.GFG160;

public class NextPermutation {
    
    static void rev(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;

        for (int i = n - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            rev(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        rev(arr, index + 1, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

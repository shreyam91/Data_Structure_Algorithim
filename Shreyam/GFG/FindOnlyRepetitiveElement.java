// Question: Find Only Repetitive Element from 1 to n-1.... 
// Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.
// Note: It is guaranteed that there is a repeating element present in the array.

// Examples:
// Input: arr[] = [1, 3, 2, 3, 4]
// Output: 3 
// Explanation: The number 3 is the only repeating element.


package shreyam.gfg;

public class FindOnlyRepetitiveElement {
    public static int findDuplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length - 1;
        long totalSum = ((long)length * ((long)(length + 1))) / 2;
        long currentSum = 0;
        for (int index = 0; index <= length; index++) {
            currentSum += arr[index];
        }
        return (int)(currentSum - totalSum);
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 3, 4};
        int res = findDuplicate(arr);
        System.out.println(res);
    }
}

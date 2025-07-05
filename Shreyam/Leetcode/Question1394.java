// Question: Find Lucky Integer in an Array

// Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
// Return the largest lucky integer in the array. If there is no lucky integer return -1.

// Example 1:
// Input: arr = [2,2,3,4]
// Output: 2

package shreyam.leetCode;

public class Question1394 {
    public static int findLucky(int[] arr) {
    int[] count = new int[arr.length + 1];

    for (final int a : arr)
      if (a <= arr.length)
        ++count[a];

    for (int i = arr.length; i >= 1; --i)
      if (count[i] == i)
        return i;

    return -1;
  }
    public static void main(String[] args) {
        int arr[] = {2,2,3,4};
        System.out.println(findLucky(arr));
    }
}

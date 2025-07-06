// Question: Finding Pairs With a Certain Sum

// You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:
// Add a positive integer to an element of a given index in the array nums2.
// Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
// Implement the FindSumPairs class:
// FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
// void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
// int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 
// Example 1:
// Input
// ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
// [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
// Output
// [null, 8, null, 2, 1, null, null, 11]

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question1865 {
    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> eleFreq;

    // Constructor
    public Question1865(int[] nums1, int[] nums2) {
        this.arr1 = nums1;
        this.arr2 = nums2.clone();
        this.eleFreq = new HashMap<>();
        for (int ele : nums2) {
            eleFreq.put(ele, eleFreq.getOrDefault(ele, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = arr2[index];
        eleFreq.put(oldVal, eleFreq.get(oldVal) - 1);
        arr2[index] += val;
        int newVal = arr2[index];
        eleFreq.put(newVal, eleFreq.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int ele : arr1) {
            int target = tot - ele;
            res += eleFreq.getOrDefault(target, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        Question1865 obj = new Question1865(nums1, nums2);

        System.out.println(obj.count(7));  // Expected output
        obj.add(3, 2);                     // arr2[3] = 2 -> 4
        System.out.println(obj.count(8));  // Expected output
        System.out.println(obj.count(4));  // Expected output
        obj.add(0, 1);                     // arr2[0] = 1 -> 2
        obj.add(1, 1);                     // arr2[1] = 4 -> 5
        System.out.println(obj.count(7));  // Expected output
    }
}

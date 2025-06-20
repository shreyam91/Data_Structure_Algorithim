// Question: Group Balls by Sequence

// You are given an array arr[] of positive integers, where each element arr[i] represents the number written on the i-th ball, and a positive integer k.
// Your task is to determine whether it is possible to rearrange all the balls into groups such that:

// Each group contains exactly k balls.
// The numbers in each group are consecutive integers
// Examples:
// Input: arr[] = [10, 1, 2, 11], k = 2
// Output: true


package shreyam.gfg;

import java.util.TreeMap;

public class GroupBallsSequence {
    public static boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0) return false;

        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int first = countMap.firstKey();

            for (int i = 0; i < k; i++) {
                int num = first + i;
                if (!countMap.containsKey(num)) {
                    return false;
                }
                countMap.put(num, countMap.get(num) - 1);
                if (countMap.get(num) == 0) {
                    countMap.remove(num);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
       int arr[] = {10, 1, 2, 11};
       int k = 2;
       System.out.println(validgroup(arr, k));
    }
}

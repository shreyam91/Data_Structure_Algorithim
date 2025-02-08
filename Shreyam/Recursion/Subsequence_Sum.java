package Shreyam.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence_Sum {

                // <--- print only one subsequence ---->
    static void findSubsequence(int[] arr, int target) {
        List<Integer> currentSubsequence = new ArrayList<>();
        if (!findSubsequenceHelper(arr, 0, target, currentSubsequence)) {
            System.out.println("No subsequence found with the target sum.");
        }
    }

    private static boolean findSubsequenceHelper(int[] arr, int index, int target, List<Integer> currentSubsequence) {
        if (index == arr.length) {
            int sum = 0;
            for (int num : currentSubsequence) {
                sum += num;
            }
            if (sum == target) {
                System.out.println(currentSubsequence);
                return true; 
            }
            return false; 
        }

        // Include current element
        currentSubsequence.add(arr[index]);
        if (findSubsequenceHelper(arr, index + 1, target, currentSubsequence)) {
            return true; 
        }

        // Exclude current element
        currentSubsequence.remove(currentSubsequence.size() - 1);
        return findSubsequenceHelper(arr, index + 1, target, currentSubsequence);
    }

                            // <--- print all subsequence ---->

    // static void findSubsequence(int[] arr, int target) {
    //     List<Integer> currentSubsequence = new ArrayList<>();
    //     findSubsequencesHelper(arr, 0, target, currentSubsequence);
    // }

    // private static void findSubsequencesHelper(int[] arr, int index, int target, List<Integer> currentSubsequence) {
    
    //     if (index == arr.length) {
    //         int sum = 0;
    //         for (int num : currentSubsequence) {
    //             sum += num;
    //         }
    //         if (sum == target) {
    //             System.out.println(currentSubsequence);
    //         }
    //         return;
    //     }

    //     // Include the current element in the subsequence
    //     currentSubsequence.add(arr[index]);
    //     findSubsequencesHelper(arr, index + 1, target, currentSubsequence);

    //     // Exclude the current element in the subsequence
    //     currentSubsequence.remove(currentSubsequence.size() - 1);
    //     findSubsequencesHelper(arr, index + 1, target, currentSubsequence);
    // }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        int target = 5;
        System.out.println("Subsequence whose sum is " + target + ":");
        findSubsequence(arr, target);
    }
}

// Question: Find the Prefix Common Array of Two Arrays... 
// You are given two 0-indexed integer permutations A and B of length n.
// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
// Return the prefix common array of A and B.
// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

// Example 1:
// Input: A = [1,3,2,4], B = [3,1,2,4]
// Output: [0,2,3,4]
// Explanation: At i = 0: no number is common, so C[0] = 0.
// At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
// At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
// At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

package Shreyam.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question2657 {
    private static int prefixMatch(int[]A, Set<Integer> setB,int size){
        int count =0;
        for(int i=0;i<=size;i++){
            if(setB.contains(A[i])){
                count++;
            }
        }
        return count;
    }
    static int[] prefixCommon(int[] A, int[] B){

        // <!-- Brute Force Approach -->
        // int len = A.length;
        // int[] freq = new int[len+1];
        // int[] res = new int[len];
        // int count =0;

        // for(int i=0;i<len;i++){
        //     freq[A[i]]++;
        //     if(freq[A[i]] == 2) {
        //         count++;
        //     }
        //     freq[B[i]]++;
        //     if(freq[B[i]] == 2){
        //         count++;
        //     }

        //     res[i] = count;
        // }
        // return res;

        // <!--- Optimal Approach using Set -->
        int len = A.length;
        int [] res = new int[len];
        Set<Integer> setB = new HashSet<>();

        for(int i=0;i<len;i++){
            setB.add(B[i]);
            res[i] = prefixMatch(A,setB,i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr1 = {1,3,2,4};
        int [] arr2 = {3,1,2,4};
        int [] result = prefixCommon(arr1, arr2);
        for(int res:result){
            System.out.println(res);
        }
    }
}

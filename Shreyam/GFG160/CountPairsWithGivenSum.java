// Question: Count pairs with given sum... 

// Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

// Examples:
// Input: arr[] = [1, 5, 7, -1, 5], target = 6 
// Output: 3
// Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 


package shreyam.GFG160;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    static int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int countPairs = 0;
        
        for(int num:arr){
            int complement = target-num;
            countPairs += map.getOrDefault(complement,0);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return countPairs;
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println(countPairs(arr, target));
    }
}

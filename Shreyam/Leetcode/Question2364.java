// Question: Count Number of Bad Pairs... 
// You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
// Return the total number of bad pairs in nums.

// Example 1:
// Input: nums = [4,1,3,3]
// Output: 5
// Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
// The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
// The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
// The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
// The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
// There are a total of 5 bad pairs, so we return 5.

package shreyam.leetCode;

import java.util.HashMap;

public class Question2364 {
    public static long countBadPairs(int[] nums){
        long n = nums.length;
        HashMap<Integer, Integer>freq = new HashMap<>();
        long goodPairs = 0;

        for(int i=0;i<n;i++){
            int key = nums[i]-i;
            if(freq.containsKey(key)){
                goodPairs += freq.get(key);
            }
            freq.put(key, freq.getOrDefault(key, 0) +1);
        }
        long badPairs = n * (n-1)/2 - goodPairs;
        return badPairs;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,3,3};
        long res = countBadPairs(nums);
        System.out.println(res);
    }
}

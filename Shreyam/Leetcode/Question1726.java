// Question: Tuple with Same Product... 
// Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.

// Example 1:
// Input: nums = [2,3,4,6]
// Output: 8
// Explanation: There are 8 valid tuples:
// (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
// (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2). 

package Shreyam.leetCode;

import java.util.HashMap;

public class Question1726 {
    private static int nC2(int n){
            return (n*(n-1))/2;
        }
        public static int tupleSameProduct(int[] nums){
            int n=nums.length;
            HashMap<Integer,Integer> freq = new HashMap<>();
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int product = nums[i] * nums[j];
                    freq.put(product, freq.getOrDefault(product, 0) +1);
                }
            }
            int count =0;
            for(int frequency: freq.values()){
                count += 8*nC2(frequency);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        int res = tupleSameProduct(nums);
        System.out.println(res);
    }
}

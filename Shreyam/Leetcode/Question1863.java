// Question: Sum of All Subset XOR Totals... 
// The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
// For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
// Given an array nums, return the sum of all XOR totals for every subset of nums. 
// Note: Subsets with the same elements should be counted multiple times.
// An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

// Example 1:
// Input: nums = [1,3]
// Output: 6

package shreyam.leetCode;

public class Question1863 {
    public static int subsetXORSum(int[] nums) {
        return findXORTotal(nums,0,0);
    }

    public static int findXORTotal (int[]nums, int index, int xor){
        if(index == nums.length) return xor;
        
        int pick = findXORTotal(nums, index+1, xor ^ nums[index]);
        int noPick = findXORTotal(nums, index+1, xor);

        return pick + noPick;
    }
    public static void main(String[] args) {
        int nums[] = {1,3};
        int res = subsetXORSum(nums);
        System.out.println(res);
    }
}

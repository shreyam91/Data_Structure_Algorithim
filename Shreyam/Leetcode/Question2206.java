// Question: Divide Array into Equal Pairs... 
// You are given an integer array nums consisting of 2 * n integers.
// You need to divide nums into n pairs such that:
// Each element belongs to exactly one pair.
// The elements present in a pair are equal.
// Return true if nums can be divided into n pairs, otherwise return false.

// Example 1:
// Input: nums = [3,2,3,2,2,2]
// Output: true

package shreyam.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Question2206 {
    public static boolean divideArray(int[] nums) {
        Set<Integer> remaining = new HashSet<>();
        for(int ele: nums){
            if(remaining.contains(ele)){
                remaining.remove(ele);
            }else{
                remaining.add(ele);
            }
        }
        return remaining.size() == 0;
    }
    public static void main(String[] args) {
        int nums [] = {3,2,3,2,2,2};
        boolean res = divideArray(nums);
        System.out.println(res);
    }
}

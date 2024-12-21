package Shreyam.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset_Sum {
    public static boolean isSubsetSum(int[] nums, int n, int target, List<Integer> currentSubset){
        if(target ==0) {
            System.out.println("Subset:" + currentSubset);
            return true;}

        if(n == 0) return false;

        if(nums[n-1] > target){
            return isSubsetSum(nums, n-1, target, currentSubset);
        }

        currentSubset.add(nums[n-1]);
        if (isSubsetSum(nums, n-1, target-nums[n-1], currentSubset)){
            return true;
        }

        currentSubset.remove(currentSubset.size()-1);

        return isSubsetSum(nums, n-1, target, currentSubset);
    }
    public static void main(String[] args) {
        int [] nums = {3,14,4,12,5,2};
        int target = 9;
        int n = nums.length;

        List<Integer> currentSubset = new ArrayList<>();
        
        if(!isSubsetSum(nums, n, target, currentSubset)){
            System.out.println("No subset with sum " + target);
        }
    }
    
}

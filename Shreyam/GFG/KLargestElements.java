// Question: K largest Elements... 
// Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 

// Examples:
// Input: arr[] = [12, 5, 787, 1, 23], k = 2
// Output: [787, 23]
// Explanation: 1st largest element in the array is 787 and second largest is 23.

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class KLargestElements {
    static ArrayList<Integer> largestElement(int[] nums,int k){
        int length = nums.length;

        if(length < k) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = length-1; i>= length-k; i--){
            res.add(nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {12,5,787,1,23};
        int k = 2;
        ArrayList<Integer> result = largestElement(nums, k);
        System.out.println(result);
    }
}

// Question: Partition Array According to Given Pivot... 
// You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
// Every element less than pivot appears before every element greater than pivot.
// Every element equal to pivot appears in between the elements less than and greater than pivot.
// The relative order of the elements less than pivot and the elements greater than pivot is maintained.
// More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
// Return nums after the rearrangement.

// Example 1:
// Input: nums = [9,12,5,10,14,3,10], pivot = 10
// Output: [9,5,3,10,10,12,14]

package shreyam.leetCode;

public class Question2161 {
    public static int[] pivotArray(int[] nums, int pivot) {
        int lCount=0;
        int gCount=0;
        int pCount=0;
        for(int num : nums){
            if(num < pivot){
                lCount++;
            }else if(num > pivot){
                gCount++;
            }else{
                pCount++;
            }
        }
        int i=0;
        int j=lCount;
        int k=lCount + pCount;
        int res[] = new int[nums.length];
        for(int num : nums){
            if(num < pivot){
                res[i] = num;
                i++;
            }else if(num > pivot){
                res[k] = num;
                k++;
            }else{
                res[j] = num;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {9,12,5,10,14,3,10};
        int pivot = 10;

        int[] res = pivotArray(nums, pivot);
        for(int ele:res){
            System.out.print(ele + " ");
        }
    }
}

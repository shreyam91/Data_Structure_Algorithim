// Question: Minimum Number of Operations to Make Elements in Array Distinct... 
// You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:
// Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
// Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.

// Example 1:
// Input: nums = [1,2,3,4,2,3,3,5,7]
// Output: 2


package shreyam.leetCode;

public class Question3396 {
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
 
         int[] hash = new int[101];
         for (int num : nums)
             hash[num]++;
 
         int ans = 0; 
         int idx = 0; 
 
         
         while (!unique(hash)) {
             int count = 3; 
             
             while (idx < n && count-- > 0) {
                 hash[nums[idx]]--;
                 idx++;
             }
 
             ans++; 
         }
 
         return ans;
     }
 
     
     private static boolean unique(int[] hash) {
         for (int i = 0; i < hash.length; i++) {
             if (hash[i] > 1) return false;
         }
         return true;
     } 
 
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,2,3,3,5,7};
        int res = minimumOperations(nums);
        System.out.println(res);
    }
}

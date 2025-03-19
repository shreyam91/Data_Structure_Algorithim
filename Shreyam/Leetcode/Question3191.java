// Question: Minimum Operations to make Binary Array Elements Equal to One I... 
// You are given a binary array nums.
// You can do the following operation on the array any number of times (possibly zero):
// Choose any 3 consecutive elements from the array and flip all of them.
// Flipping an element means changing its value from 0 to 1, and from 1 to 0.
// Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.

// Example 1:
// Input: nums = [0,1,1,1,0,0]
// Output: 3

package shreyam.leetCode;

public class Question3191 {
    private static void flipWindow(int[] nums, int pos) {
            nums[pos] ^= 1;       
            nums[pos + 1] ^= 1;   
            nums[pos + 2] ^= 1;   
        }
    
        public static int minOperations(int[] nums) {
            int n = nums.length;
            int operations = 0;
    
            for (int i = 0; i < n - 2; ++i) {
                if (nums[i] == 1) {
                    continue; 
                }
                flipWindow(nums, i); 
            operations++;        
        }

        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1; 
        }

        return operations; 
    }
    public static void main(String[] args) {
        int nums [] = {0,1,1,1,0,0};
        int res = minOperations(nums);
        System.out.println(res);
    }
}

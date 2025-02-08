// Question: Make Lexicographically Smallest Array by Swapping Elements... 
// You are given a 0-indexed array of positive integers nums and a positive integer limit.
// In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
// Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
// An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.

// Example 1:
// Input: nums = [1,5,3,9,8], limit = 2
// Output: [1,3,5,8,9]
// Explanation: Apply the operation 2 times:
// - Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
// - Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
// We cannot obtain a lexicographically smaller array by applying any more operations.
// Note that it may be possible to get the same result by doing different operations. 

package Shreyam.leetCode;

import java.util.*;

public class Question2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<int[]> copy = new ArrayList<>();
        for(int i=0; i<n; i++){
            copy.add(new int[]{nums[i],i});
        }

        copy.sort(Comparator.comparingInt(a -> a[0]));
        int left =0, right=1;
        while(right<n){
            List<Integer> pos = new ArrayList<>();
            pos.add(copy.get(left)[1]);

            while (right < n && Math.abs(copy.get(right)[0] - copy.get(right - 1)[0]) <= limit){
                pos.add(copy.get(right)[1]);
                right++;
            }
            Collections.sort(pos);
            for(int i=0; i<right-left; i++){
                nums[pos.get(i)] = copy.get(left+i)[0];
            }
            left = right;
            right++;
        }

        return nums;
    }
    public static void main(String[] args) {
        int [] arr = {1,5,3,9,8};
        int limit = 2;

        Question2948 solution = new Question2948();
        int[] result = solution.lexicographicallySmallestArray(arr, limit);

        System.out.println(Arrays.toString(result));

    }
}

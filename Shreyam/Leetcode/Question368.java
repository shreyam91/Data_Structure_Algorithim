// Question: Largest Divisible Subset... 
// iven a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

// Example 1:
// Input: nums = [1,2,3]
// Output: [1,2]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question368 {
    public static  List<Integer> largestDivisibleSubset(int[] nums) {
    final int n = nums.length;
    List<Integer> ans = new ArrayList<>();
    int[] sizeEndsAt = new int[n];
   
    int[] prevIndex = new int[n];
    int maxSize = 0; 
    int index = -1;  

    Arrays.fill(sizeEndsAt, 1);
    Arrays.fill(prevIndex, -1);
    Arrays.sort(nums);

    for (int i = 0; i < n; ++i) {
      for (int j = i - 1; j >= 0; --j)
        if (nums[i] % nums[j] == 0 && sizeEndsAt[i] < sizeEndsAt[j] + 1) {
          sizeEndsAt[i] = sizeEndsAt[j] + 1;
          prevIndex[i] = j;
        }
      if (maxSize < sizeEndsAt[i]) {
        maxSize = sizeEndsAt[i];
        index = i; 
      }
    }

    while (index != -1) {
      ans.add(nums[index]);
      index = prevIndex[index];
    }

    return ans;
  }
    public static void main(String[] args) {
       int nums[] = {1,2,3};
       List<Integer> res = largestDivisibleSubset(nums);
       System.out.println(res);
    }
}

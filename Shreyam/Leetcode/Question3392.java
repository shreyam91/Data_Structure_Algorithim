// Question: Count Subarrays of Length Three With a Condition.. 
// Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

// Example 1:
// Input: nums = [1,2,1,4,1]
// Output: 1


package shreyam.leetCode;

public class Question3392{
  public static int countSubarrays(int[] nums) {
    int ans = 0;

    for (int i = 1; i + 1 < nums.length; ++i)
      if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2)
        ++ans;

    return ans;
}
public static void main(String[] args) {
    int [] nums = {1,2,1,4,1};
    int res = countSubarrays(nums);
    System.out.println(res);
}
}




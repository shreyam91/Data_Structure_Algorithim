// Question: House Robber IV... 
// There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
// The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
// You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
// You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
// Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

// Example 1:
// Input: nums = [2,3,5,9], k = 2
// Output: 5

package shreyam.leetCode;

import java.util.Arrays;

public class Question2560 {
    private static boolean canAssign(int maxVal, int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxVal) {
                count++;
                i++; 
            }
        }
        return count >= k;
    }

    public static int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, nums, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {2,3,5,9};
        int k = 2;

        int res = minCapability(nums, k);
        System.out.println(res);
    }
}

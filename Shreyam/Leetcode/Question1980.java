// Question: Find Unique Binary String... 
// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

// Example 1:
// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.

package shreyam.leetCode;

public class Question1980 {
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < n; i++){
            char ch = (nums[i].charAt(i) == '0' ? '1' : '0');
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"01", "10"};
        String res = findDifferentBinaryString(nums);
        System.out.println(res);
    }
}

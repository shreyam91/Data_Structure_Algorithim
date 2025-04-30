// Question: Find Numbers with Even Numbers of Digits... 
// Given an array nums of integers, return how many of them contain an even number of digits.

// Example 1:
// Input: nums = [12,345,2,6,7896]
// Output: 2

package shreyam.leetCode;

public class Question1295 {
    public static int findNumbers(int[] nums) {
        int evenCount = 0;
        for(int num:nums){
            int digits = 0;
            while(num > 0){
                num = num/10;
                digits++;
            }
            if(digits % 2 == 0){
                evenCount++;
            }
        }
        return evenCount;
    }
    public static void main(String[] args) {
        int [] nums = {12,345,2,6,7896};
        int res = findNumbers(nums);
        System.out.println(res);
    }
}

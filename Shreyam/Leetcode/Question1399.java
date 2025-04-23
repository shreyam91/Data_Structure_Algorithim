// Question: Count Largest Group... 
// You are given an integer n.
// Each number from 1 to n is grouped according to the sum of its digits.
// Return the number of groups that have the largest size.

// Example 1:
// Input: n = 13
// Output: 4

package shreyam.leetCode;

public class Question1399 {
    public static int countLargestGroup(int n) {
        int[] hash = new int[40];
   
           int max = 0;  
           for(int i = 1; i <= n; i++) {
               int ds = digitSum(i);
   
               hash[ds]++;
   
               if(hash[ds] > max) max = hash[ds];
           }
   
           int ans = 0;  
   
           for(int i = 0; i < 40; i++) {
               if(hash[i] == max) ans++;
           }
   
           return ans;
       }
   
       private static  int digitSum(int n) {
           int sum = 0;
   
           while(n > 0) {
               sum += n % 10;
               n /= 10;
           }
   
           return sum;
       }
    public static void main(String[] args) {
        int n = 13;
        int res = countLargestGroup(n);
        System.out.println(res);
    }
}

// Question: Find the Maximum Sum of Node Values 

package shreyam.leetCode;

public class Question3068 {
    public static  long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        long count = 0;
        long discardedNode = Integer.MAX_VALUE;
        
        for (int num : nums) {
            ans += Math.max(num, num ^ k);
            count += (num ^ k) > num ? 1 : 0;
            discardedNode = Math.min(discardedNode, Math.abs(num - (num ^ k)));
        }
        
        return count % 2 == 0 ? ans : (ans - discardedNode);
    }
    public static void main(String[] args) {
        
    }
}

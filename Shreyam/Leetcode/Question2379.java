// Question: Minimum Recolors to Get K Consecutive Black Blocks... 
// You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
// You are also given an integer k, which is the desired number of consecutive black blocks.
// In one operation, you can recolor a white block such that it becomes a black block.
// Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

// Example 1:
// Input: blocks = "WBBWWBBWBW", k = 7
// Output: 3

package shreyam.leetCode;

public class Question2379 {
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int black =0;
        int minRecoloring = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(blocks.charAt(i) == 'B'){
                black++;
            }
            if(i >= k-1){
                minRecoloring = Math.min(k-black,minRecoloring);
                if(blocks.charAt(i-k+1) == 'B'){
                    black--;
                }
            }
        }
        return minRecoloring;
        
    }
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k=7;
        int res = minimumRecolors(blocks, k);
        System.out.println(res);

    }
}

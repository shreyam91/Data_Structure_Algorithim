// Question: Alternating Groups II... 
// There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
// colors[i] == 0 means that tile i is red.
// colors[i] == 1 means that tile i is blue.
// An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
// Return the number of alternating groups.
// Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

// Example 1:
// Input: colors = [0,1,0,1,0], k = 3
// Output: 3
package shreyam.leetCode;

public class Question3208 {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int ans = 0, cnt = 0;
            for (int i = 0; i < n << 1; ++i) {
                if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                    cnt = 1;
                } else {
                    ++cnt;
                }
                ans += i >= n && cnt >= k ? 1 : 0;
            }
            return ans;
        }
        public static void main(String[] args) {
            int [] colors = {0, 1, 0, 1, 0};    
            int k =3;
            int res = numberOfAlternatingGroups(colors, k);
        System.out.println(res);
    }
}

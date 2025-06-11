// Question: Remove the balls 
// You are given two arrays, color and radius, representing a sequence of balls:
// color[i] is the color of the i-th ball.
// radius[i] is the radius of the i-th ball.
// If two consecutive balls have the same color and radius, remove them both. Repeat this process until no more such pairs exist.
// Return the number of balls remaining after all possible removals.

// Examples:
// Input: color[] = [2, 3, 5], radius[] = [3, 3, 5]
// Output: 3

package shreyam.gfg;

import java.util.Stack;

public class RemoveTheBalls {
    public static int findLength(int[] color, int[] radius) {
        Stack<Integer> st = new Stack();
        for(int i=0;i<color.length;i++){
            if(!st.isEmpty()&&color[st.peek()] == color[i] && radius[st.peek()] == radius[i]){
                st.pop();
            }
            else st.push(i);
        }
        return st.size();
    }
 public static void main(String[] args) {
    int color[] = {2, 3, 5}, radius[] = {3, 3, 5};
    System.out.println(findLength(color, radius));
 }   
}

// Question: Lexicographical Numbers 

// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

// Example 1:
// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

package shreyam.leetCode;
import java.util.ArrayList;
import java.util.List;

public class Question386{
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int currNum = 1;
        for (int i = 0; i < n; i++) {
            res.add(currNum);
            if (currNum * 10 <= n) {
                currNum *= 10;
            } else {
                while (currNum % 10 == 9 || currNum >= n) {
                    currNum /= 10;
                }
                currNum += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
}
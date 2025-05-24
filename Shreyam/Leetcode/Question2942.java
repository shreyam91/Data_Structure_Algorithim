// Question: Find Words Containing Character 

// You are given a 0-indexed array of strings words and a character x.
// Return an array of indices representing the words that contain the character x.
// Note that the returned array may be in any order.

// Example 1:
// Input: words = ["leet","code"], x = "e"
// Output: [0,1]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question2942 {
    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                if (ch == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       String [] words = {"leet","code"};
       char x = 'e';
        System.out.println(findWordsContaining(words, x));
    }
}

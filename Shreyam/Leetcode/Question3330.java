// Question: Find the Original Typed String I

// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
// Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
// You are given a string word, which represents the final output displayed on Alice's screen.
// Return the total number of possible original strings that Alice might have intended to type.

// Example 1:
// Input: word = "abbcccc"
// Output: 5


package shreyam.leetCode;

public class Question3330 {
    public static int possibleStringCount(String word) {
        int n = word.length();
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                res++;
            }
        }
        return res + 1;
    }
    public static void main(String[] args) {
       String word = "abbcccc";
       System.out.println(possibleStringCount(word));
    }
}

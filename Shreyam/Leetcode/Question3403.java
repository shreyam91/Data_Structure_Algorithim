// Question: Find the Lexicographically Largest String From the Box I

// You are given a string word, and an integer numFriends.
// Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
// word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
// All the split words are put into a box.
// Find the lexicographically largest string from the box after all the rounds are finished.

// Example 1:
// Input: word = "dbca", numFriends = 2
// Output: "dbc"

package shreyam.leetCode;

public class Question3403 {
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int minLen = Math.min(n - numFriends + 1, n - i);
            String sub = word.substring(i, i + minLen);
            if (res.compareTo(sub) < 0) {
                res = sub;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String word = "dbca";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
    }
}

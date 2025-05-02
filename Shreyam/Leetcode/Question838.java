// Question: Push Dominoes... 
// There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
// After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
// For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
// You are given a string dominoes representing the initial state where:
// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
// Return a string representing the final state.

// Example 1:
// Input: dominoes = "RR.L"
// Output: "RR.L"

package shreyam.leetCode;

public class Question838{
    public static String pushDominoes(String dominoes) {
        String s = "L" + dominoes + "R";
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 1; j < n; j++) {
            if (s.charAt(j) == '.') continue;

            int midPartLength = j - i - 1;
            if (i > 0)
                result.append(s.charAt(i));

            if (s.charAt(i) == s.charAt(j))
                result.append(String.valueOf(s.charAt(i)).repeat(midPartLength));
            else if (s.charAt(i) == 'L' && s.charAt(j) == 'R')
                result.append(".".repeat(midPartLength));
            else {
                int half = midPartLength / 2;
                result.append("R".repeat(half));
                if (midPartLength % 2 == 1) result.append('.');
                result.append("L".repeat(half));
            }

            i = j;
        }

        return result.toString();
        
    }
    public static void main(String[] args) {
        String dominoes = "RR.L";
        System.out.println(pushDominoes(dominoes));
    }
}
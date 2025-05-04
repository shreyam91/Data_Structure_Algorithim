// Question: Number of Equivalent Domino Pairs... 
// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

// Example 1:
// Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
// Output: 1

package shreyam.leetCode;

public class Question1128{
    public static int numEquivDominoPairs(int[][] dominoes) {

        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int num = a * 10 + b;
            result += count[num];
            count[num]++;
        }

        return result;
    }
    public static void main(String[] args) {
        int dominoes[][] = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }
}
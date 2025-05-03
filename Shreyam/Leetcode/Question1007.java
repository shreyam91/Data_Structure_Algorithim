// Question: Minimum Domino Rotation for Equal Row... 
// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

// If it cannot be done, return -1.
// Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// Output: 2

package shreyam.leetCode;

public class Question1007{
    private static int tryRotationMatching(int number, int[] first, int[] second) {
        int count = 0;
        for (int i = 0; i < first.length; ++i) {
            if (first[i] == number) {
            } else if (second[i] == number) count++;
            else return Integer.MAX_VALUE;
        }
        return count;
    }
    public static  int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;
        for (int number = 1; number <= 6; number++) {
            int countTops = tryRotationMatching(number, tops, bottoms);
            int countBottoms = Integer.MAX_VALUE;
            if (countTops != Integer.MAX_VALUE) {
                countBottoms = tryRotationMatching(number, bottoms, tops);
            }
            minRotations = Math.min(minRotations, Math.min(countTops, countBottoms));
        }
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
    public static void main(String[] args) {
        int [] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        System.out.println(minDominoRotations(tops, bottoms));
    }
}
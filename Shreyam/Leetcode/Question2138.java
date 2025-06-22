// Question: Divide a String Into Groups of Size k 

// A string s can be partitioned into groups of size k using the following procedure:
// The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
// For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
// Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.
// Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.

// Example 1:
// Input: s = "abcdefghi", k = 3, fill = "x"
// Output: ["abc","def","ghi"]

package shreyam.leetCode;

import java.util.Arrays;

public class Question2138{
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int totalParts = (n + k - 1) / k; 
        String[] result = new String[totalParts];
        int index = 0;

        for (int i = 0; i < n; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n) {
                    sb.append(s.charAt(j));
                } else {
                    sb.append(fill);
                }
            }
            result[index++] = sb.toString();
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';

        System.out.println(Arrays.toString(divideString(s, k, fill)));
    }
}
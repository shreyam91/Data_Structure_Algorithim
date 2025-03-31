// Question: Maximize partitions in a String... 
// Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.

// Examples:
// Input: s = "acbbcc"
// Output: 2

package shreyam.gfg;

public class MaximizePartitionsString {
    public static int maxPartitions(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) 
            last[s.charAt(i) - 'a'] = i;
        int count = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "acbbcc";
        int result = maxPartitions(s);
        System.out.println(result);
    }
    
}

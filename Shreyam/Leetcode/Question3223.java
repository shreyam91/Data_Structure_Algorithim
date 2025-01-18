// Question:-  Minimum Length of String After Operations... 
// You are given a string s.
// You can perform the following process on s any number of times:
// Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
// Delete the closest character to the left of index i that is equal to s[i].
// Delete the closest character to the right of index i that is equal to s[i].
// Return the minimum length of the final string s that you can achieve.

// Example 1:
// Input: s = "abaacbcbb"
// Output: 5
// Explanation:
// We do the following operations:
// Choose index 2, then remove the characters at indices 0 and 3. The resulting string is s = "bacbcbb".
// Choose index 3, then remove the characters at indices 0 and 5. The resulting string is s = "acbcb".

package Shreyam.LeetCode;

public class Question3223 {
    static int minLength(String s){
        int freq[] = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        int length =0;
        for(int count : freq){
            if(count %2 == 1){
                length += 1;
            }else{
                length += Math.min(2, count);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        String s = "abaacbcbb";
        int result = minLength(s);
        System.out.println(result);

    }
    
}

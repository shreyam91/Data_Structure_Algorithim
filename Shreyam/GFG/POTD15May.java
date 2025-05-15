// Question: Substrings with same first and last characters

// Given a string s consisting of lowercase characters, the task is to find the count of all substrings that start and end with the same character.

// Examples:
// Input: s = "abcab"
// Output: 7

package shreyam.gfg;

import java.util.HashMap;

public class POTD15May {
    public static int countSubstring(String s) {
        int n=s.length();
       int count=0;
       HashMap<Character,Integer>ans=new HashMap<>();
       for(int i=0;i<n;i++){
           char ch=s.charAt(i);
           ans.put(ch,ans.getOrDefault(ch,0)+1);
           count+=ans.get(ch);
       }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(countSubstring(s));
    }
}

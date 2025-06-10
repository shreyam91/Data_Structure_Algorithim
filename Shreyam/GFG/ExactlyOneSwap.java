// Question: Exactly one swap 
// Given a string s, return the number of distinct strings that can be obtained by exactly one swap of two different indices (i < j).

// Examples:

// Input: s = "geek"
// Output: 6

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class ExactlyOneSwap {
    static int countStrings(String s) {
        Map<Character, Integer> freq = new HashMap();
        for(char ch: s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        int ans = 0;
        int len = s.length();
        boolean flag = false;
        for(char ch: s.toCharArray()){
            if(freq.get(ch) > 1){
                flag = true;
            }
            ans+=len - freq.get(ch);
        }
        ans/=2;
        ans+=flag ? 1 : 0;
        return ans;
    }
    public static void main(String[] args) {
        String s = "geek";
        System.out.println(countStrings(s));
    }
}

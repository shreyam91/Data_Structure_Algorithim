// Question: Smallest distinct window... 
// Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

// Example:
// Input: str = "aabcbcdbca"
// Output: 4

package shreyam.gfg;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow {
    public static int findSubString(String str) {
        Set<Character> st=new HashSet<>();
        for(char i:str.toCharArray())
        st.add(i);
        int cnt=Integer.MAX_VALUE;
        int r=0,l=0;
        Map<Character,Integer> map=new LinkedHashMap<>();
        while(r<str.length())
        {
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
            if(map.size()==st.size())
            {
                while(map.size()==st.size())
                {
                    cnt=Math.min(cnt,r-l+1);
                    map.put(str.charAt(l),map.get(str.charAt(l))-1);
                    if(map.get(str.charAt(l))==0)
                    map.remove(str.charAt(l));
                    l++;
                }
            }
            r++;
        }
        return cnt;
        
    }
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(findSubString(str));
    }
}

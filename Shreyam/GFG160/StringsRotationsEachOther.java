// Question: Strings Rotations of Each Other... 
// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.
// Note: The characters in the strings are in lowercase.

// Examples :
// Input: s1 = "abcd", s2 = "cdab"
// Output: true


package shreyam.GFG160;

import java.util.Arrays;

public class StringsRotationsEachOther {
    public static boolean areRotations(String s1, String s2) {
        if( s1.length() != s2.length()) return false;

        // String concatenated = s1 + s1;
        // return concatenated.contains(s2);

        StringBuilder temp = new StringBuilder(s2);
        temp.append('$').append(s1).append(s1);
        int n = temp.length(),i=0,j=1,m=s2.length();
        int lps[] = new int[n];
        Arrays.fill(lps,0);
        String str = temp.toString();
        while(j<n){
            if(str.charAt(i)==str.charAt(j)){
                lps[j++]=++i;
                if(i==m)return true;
            }
            else if(i!=0)i=lps[i-1];
            else j++;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        boolean res = areRotations(s1, s2);
        System.out.println(res);
    }
}

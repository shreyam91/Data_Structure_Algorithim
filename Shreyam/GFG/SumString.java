// Question: SumString 

// Given a string s consisting of digits, determine whether it can be classified as a sum-string.
// A sum-string is a string that can be split into more than two non-empty substrings such that:
// The rightmost substring is equal to the sum of the two substrings immediately before it (interpreted as integers).
// This condition must apply recursively to the substrings before it.
// The rightmost substring (and any number in the sum) must not contain leading zeroes, unless the number is exactly '0'.

// Examples:
// Input: s = "12243660"
// Output: true

package shreyam.gfg;

public class SumString {
    private static String addStrings(String num1, String num2) {
        StringBuilder ans=new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        while(i>=0||j>=0||carry==1)
        {
            int v1=i>=0?num1.charAt(i)-'0':0;
            int v2=j>=0?num2.charAt(j)-'0':0;
            int sum=v1+v2+carry;
            carry=sum/10;
            ans.insert(0,sum%10);
            i--;j--;
        }
        return ans.toString();
    }
    private static boolean checkSeq(String s, int str, int len1, int len2){
        String s1 = s.substring(str, str+len1);
        String s2 = s.substring(str+len1, str+len1+len2);
        String sum = addStrings(s1, s2);
        int sumLen = sum.length();
        
        if(str+len1+len2+sumLen > s.length()){
            return false;
        }
        if(sum.equals(s.substring(str+len1+len2, str+len1+len2+sumLen))){
            if(str+len1+len2+sumLen == s.length()){
                return true;
            }
            return checkSeq(s, str+len1, len2, sumLen);
        }
        return false;
        
    }
    public static boolean isSumString(String s) {
        int n = s.length();
        for(int len1 = 1; len1< n; len1++){
            for(int len2 = 1; len1 + len2 < n ; len2++){
                if(checkSeq(s, 0, len1, len2)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "12243660";
        System.out.println(isSumString(s));
    }
}

// Question: Add Binary Strings... 
// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

// Input: s1 = "1101", s2 = "111"
// Output: 10100


package shreyam.GFG160;

public class AddBinaryStrings {
    public static  String addBinary(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int count1s = 0;
            if (i >= 0 && s1.charAt(i) == '1') count1s++;
            if (j >= 0 && s2.charAt(j) == '1') count1s++;
            
            if (count1s + carry == 0) {
                ans.append('0');
                carry = 0;
            } else if (count1s + carry == 1) {
                ans.append('1');
                carry = 0;
            } else if (count1s + carry == 2) {
                ans.append('0');
                carry = 1;
            } else if (count1s + carry == 3) {
                ans.append('1');
                carry = 1;
            }            
            i--;
            j--;
        }
        
        if (carry == 1) {
            ans.append('1');
        }
        
        ans.reverse();        
        int index = 0;
        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }
        
        if (index == ans.length()) {
            return "0";
        }
        
        return ans.substring(index).toString();
    }
    public static void main(String[] args) {
       String s1 = "1101";
       String s2 = "111";
       String res = addBinary(s1, s2);
        System.out.println(res);

    }
}

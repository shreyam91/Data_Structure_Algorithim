// Question: Delete Characters to Make Fancy String

// A fancy string is a string where no three consecutive characters are equal.
// Given a string s, delete the minimum possible number of characters from s to make it fancy.
// Return the final string after the deletion. It can be shown that the answer will always be unique.

// Example 1:
// Input: s = "leeetcode"
// Output: "leetcode"


package shreyam.leetCode;

public class Question1957 {
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray())
      if (sb.length() < 2 || 
          sb.charAt(sb.length() - 1) != c || sb.charAt(sb.length() - 2) != c)
        sb.append(c);
    return sb.toString();
    }
    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyString(s));
    }
}

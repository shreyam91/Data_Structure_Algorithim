// package Shreyam;

// public class longestPalindrome {

//     public int longestPalindromeString(String s) {
//         if(s==null || s.length()==0)
//         return 0;
//         if(s.length()==1)
//         return 1;

//         int alpha[] = new int[128];
//         int max_length=0;
//         for(char c:s.toCharArray()){
//             alpha[c]++;
//             if(alpha[c]==2)
//             {
//                 max_length+=2;
//                 alpha[c]=0;
//             }
//         }
//         if(s.length()>max_length)
//             return max_length+1;
//         else
//             return max_length;
        
//     }
//     public static void main(String[] args) {
//         longestPalindrome lp = new longestPalindrome();
//         String s = "aabccdd";
//         System.out.println(lp.longestPalindromeString(s));
//     }
    
// }

package Shreyam;

public class longestPalindrome {
    public String longestPalindromeString(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        longestPalindrome lp = new longestPalindrome();
        String input = "abccccdd";
        System.out.println("Longest Palindrome: " + lp.longestPalindromeString(input));
    }
}

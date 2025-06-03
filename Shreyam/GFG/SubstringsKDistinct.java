// Question: Substrings with K Distinct 

// Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

// Examples :
// Input: s = "abc", k = 2
// Output: 2

package shreyam.gfg;

public class SubstringsKDistinct {
   static int countSubstr(String s, int k) {
        int n      = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 
            int distinctCnt = 0;      

            for (int j = i; j < n; j++) {
                if (freq[s.charAt(j) - 'a'] == 0) {
                    distinctCnt++;         
                }
                freq[s.charAt(j) - 'a']++; 

                if (distinctCnt == k) {
                    result++; 
                } else if (distinctCnt > k) {
                    break;    
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(countSubstr(s, k));
    }
}

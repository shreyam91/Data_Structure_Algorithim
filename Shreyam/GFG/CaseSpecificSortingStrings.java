// Question: Case-specific Sorting of Strings

// Given a string s consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

// Examples :

// Input: s = "GEekS"
// Output: EGekS

package shreyam.gfg;

public class CaseSpecificSortingStrings{
    public static String caseSort(String s) {
        int n = s.length();
        int[] lower = new int[26], upper = new int[26];
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a']++;
            } else {
                upper[ch - 'A']++;
            }
        }
        StringBuilder result = new StringBuilder(s);
        int l = 0, u = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                while (lower[l] == 0) {
                    l++;
                }
                result.setCharAt(i, (char)('a' + l));
                lower[l]--;
            } else {
                while (upper[u] == 0) {
                    u++;
                }
                result.setCharAt(i, (char)('A' + u));
                upper[u]--;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
       String s = "GEekS";
       System.out.println(caseSort(s));
    }
}

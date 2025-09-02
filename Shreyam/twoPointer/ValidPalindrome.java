// Question: Valid Palindrome

// Given a string s, return true if it is a palindrome, otherwise return false.
// A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
// Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

// Example 1:
// Input: s = "tab a cat"
// Output: true

package shreyam.twoPointer;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // String reversed = new StringBuilder(s).reverse().toString();
        // return s.equals(reversed);

        // int left = 0;
        // int right = s.length() - 1;

        // while (left < right) {
        //     if (s.charAt(left) != s.charAt(right)) {
        //         return false; 
        //     }
        //     left++;
        //     right--;
        // }

        int length = s.length();

        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;  
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }
}

// Question: Valid Word

// A word is considered valid if:
// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.
// Return true if word is valid, otherwise, return false.
// Notes:
// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.
 
// Example 1:
// Input: word = "234Adas"
// Output: true

package shreyam.leetCode;

public class Question3136 {
   public static boolean isValid(String word) {
    if (word.length() < 3) return false;

    boolean hasVowel = false;
    boolean hasConsonant = false;
    boolean hasDigit = false;

    for (char c : word.toCharArray()) {
        if ("aeiouAEIOU".indexOf(c) != -1) {
            hasVowel = true;
        } else if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) {
            hasConsonant = true;
        } else if (Character.isDigit(c)) {
            hasDigit = true;
        }

        // Early exit if all are found
        if (hasVowel && hasConsonant && hasDigit) {
            return true;
        }
    }

    return false;
}

    public static void main(String[] args) {
        String word = "234Adas";
        System.out.println(isValid(word));
    }
}

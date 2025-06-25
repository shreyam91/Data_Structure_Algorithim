// Question: Check if frequencies can be equal 

// Given a string s consisting only lowercase alphabetic characters, check whether it is possible to remove at most one character such that the  frequency of each distinct character in the string becomes same. Return true if it is possible; otherwise, return false.

// Examples:
// Input: s = "xyyz"
// Output: true 

package shreyam.gfg;

public class CheckFrequenciesEqual {
    public static boolean sameFreq(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxFreqValue = Integer.MIN_VALUE;
        int minFreqValue = Integer.MAX_VALUE;
        int maxFreqCounter = 0;
        int minFreqCounter = 0;

        for (int f : freq) {

            if (f == 0) continue;

            if (f == maxFreqValue) {

                maxFreqCounter++;
            }
            if (f == minFreqValue) {

                minFreqCounter++;
            }
            if (f > maxFreqValue) {

                maxFreqValue = f;
                maxFreqCounter = 1;
            }
            if (f < minFreqValue) {

                minFreqValue = f;
                minFreqCounter = 1;
            }
        }

        if ((maxFreqValue - minFreqValue) == 0) {
            return true;
        } else if ((maxFreqValue - minFreqValue) == 1 &&
                   (maxFreqCounter == 1 ||
                    (minFreqCounter == 1 && minFreqValue == 1))) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
       String s = "xyyz";
        System.out.println(sameFreq(s));
    }
}

// Question:- Counting words with a given prefix.. 

// You are given an array of strings words and a string pref.
// Return the number of strings in words that contain pref as a prefix.
// A prefix of a string s is any leading contiguous substring of s.

// Example 1:

// Input: words = ["pay","attention","practice","attend"], pref = "at"
// Output: 2
// Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

package shreyam.leetCode;

public class Question2185 {
    public static int prefixCount (String[] words,String prefix){
        // <!-- Brute force approach --> 
        // int length = words.length;
        // int count = 0;
        // for(int i=0;i<length;i++){
        //     if(words[i].startsWith(prefix)){
        //         count++;
        //     }
        // }
        // return count;

        // <!--- Optimal Approach or Approach 2   (Both approach takes same time )--->

        int count = 0;
        for (String word : words) {
            boolean isPrefix = true;
            for (int i = 0; i < prefix.length(); ++i) {
                if (i >= word.length() || word.charAt(i) != prefix.charAt(i)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                count++;
            }
        }
        return count;
    } 
    public static void main(String[] args) {
        String [] words = {"pay","attention","practice","attend"};
        String prefix = "at";
        int result = prefixCount(words, prefix);
        System.out.println("There are " + result + " words which are start with prefix :- " + prefix );
    }
}

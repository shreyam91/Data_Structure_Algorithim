// Question: Non Repeating Character... 
// Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
// If there is no non-repeating character, return '$'.
// Note: When you return '$' driver code will output -1.

// Examples:
// Input: s = "geeksforgeeks"
// Output: 'f'

package shreyam.GFG160;

public class NonRepeatingCharacter {
    static char nonRepeatingChar(String s) {

        int freq[] = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }

        return '$';
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        char result = nonRepeatingChar(s);
        System.out.println(result);
    }
}

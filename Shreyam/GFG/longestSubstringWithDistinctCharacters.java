// Question:- Longest substring with distinct characters.. 
// Given a string s, find the length of the longest substring with all distinct characters. 

// Examples:
// Input: s = "geeksforgeeks"
// Output: 7
// Explanation: "eksforg" is the longest substring with all distinct characters.

package shreyam.gfg;

public class longestSubstringWithDistinctCharacters {
    static int distinctCharacter(String word){
        int length = word.length();
        int[] freq = new int[26];
        int i=0,j=0,count=0;
        while(j<length){
            int ch = word.charAt(j) -'a';
            if(freq[ch] >0){
                count= Math.max(count, j-i);
                while(i<j && word.charAt(i) != word.charAt(j)){
                    freq[word.charAt(i)-'a']=0;
                    i++;
                }
                i++;
            }else{
                freq[ch]++;
            }
            j++;
        }
        count = Math.max(count, j-i);

        return count;
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks"; 
        int result = distinctCharacter(s);
        System.out.println("There are " + result + " disctinct characters.");
    }
}

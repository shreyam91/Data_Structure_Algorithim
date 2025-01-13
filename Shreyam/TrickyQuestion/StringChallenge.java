// Question: String Challenge...

// Have the function StringChallenge (str) take the str parameter being passed and return a compressed version of the string using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character and outputting that number along with a single character of the repeating sequence. For example: "wwwggopp" would return 3w2g102p. The string will not contain any numbers, punctuation, or symbols.

// Once your function is working, take the final output string and combine it with your ChallengeToken, both in reverse order and separated by a colon.
// Your Challenge Token: Ichazwbgd31

// Examples
// Input: "aabbcde"
// Output: 2a2b1c1d1e
// Final Output: e1d1c1b2a2:13dgbwzahcl

package Shreyam.TrickyQuestion;

public class StringChallenge {
    static String string(String str){
        StringBuilder comp = new StringBuilder();
        int count = 1;
        for(int j=1;j<str.length();j++){
            if(str.charAt(j) == str.charAt(j-1)){
                count++;
            }else{
                comp.append(count).append(str.charAt(j-1));
                count = 1;
            }
        }
        comp.append(count).append(str.charAt(str.length()-1));

        String token = "lchazwbgd31";
        String output = comp.reverse().toString() + ":" + new StringBuilder(token).reverse();

        return output;
    }
    public static void main(String[] args) {
        String str = "aabbcde";
        System.out.println(string(str));
    }
}

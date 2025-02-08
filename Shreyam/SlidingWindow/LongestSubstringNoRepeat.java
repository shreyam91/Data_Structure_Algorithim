// Longest substring with No Repeating Character

package Shreyam.slidingWindow;

import java.util.HashMap;

public class LongestSubstringNoRepeat {
    public static Result noRepeatCharacter(String s){
        HashMap<Character,Integer> charIndexMap = new HashMap<>();
        int maxLength =0, leftPointer=0,startIndex=0;

        for(int rightPointer =0;rightPointer<s.length();rightPointer++){
            char currentChar = s.charAt(rightPointer);

            if(charIndexMap.containsKey(currentChar)){
                leftPointer = Math.max(charIndexMap.get(currentChar) +1, leftPointer);
            }

            charIndexMap.put(currentChar, rightPointer);

            if(rightPointer - leftPointer +1 >maxLength){
                maxLength = rightPointer - leftPointer +1;
                startIndex = leftPointer;
            }
        }
        String longestSubString = s.substring(startIndex,startIndex + maxLength);

        return new Result(maxLength,longestSubString);
    }

    static class Result{
        int length;
        String subString;

        Result(int length,String subString){
            this.length = length;
            this.subString = subString;

        }
    }
    public static void main(String[] args) {
        String s = "pwwrew";
        Result res = noRepeatCharacter(s);
        System.out.println("Character which makes long subString is: " + res.length + ":  " + res.subString);
    }
    
}

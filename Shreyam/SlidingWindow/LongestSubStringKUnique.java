package Shreyam.SlidingWindow;

import java.util.HashMap;

public class LongestSubStringKUnique {
    public static String kUnique(String s, int K){
        if(s==null || K<=0){
            return " ";
        }
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int left =0,maxLength=0,start=0;

        for(int right=0;right<s.length();right++){
            char currentChar = s.charAt(right);
            charCountMap.put(currentChar,charCountMap.getOrDefault(currentChar, 0)+1);
            
            while(charCountMap.size() > K){
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar,charCountMap.get(leftChar)-1);
                if(charCountMap.get(leftChar)==0){
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            if(charCountMap.size() ==K){
                int currentLength = right-left+1;
                if(currentLength > maxLength){
                    maxLength = currentLength;
                    start = left;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";    
        int K = 3;

        String result = kUnique(s, K);
        System.out.println("Longest substring is:" + result.length() + "substring: "+ result);
    }
}

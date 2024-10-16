package Shreyam.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class CountOccurenceAnagram {
    public static int countAnagram(String str, String pattern){
        int ans =0;
        int strLength = str.length();
        int patternLength = pattern.length();
        
        if(strLength < patternLength) return 0;     // edge case;

        Map<Character, Integer> patternCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        for(char ch: pattern.toCharArray()){
            patternCount.put(ch,patternCount.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<strLength;i++){
            windowCount.put(str.charAt(i),windowCount.getOrDefault(str.charAt(i), 0)+1);

            if(i>= patternLength){
                char leftChar = str.charAt(i-patternLength);
                windowCount.put(leftChar,windowCount.get(leftChar) -1);
                if(windowCount.get(leftChar) == 0){
                    windowCount.remove(leftChar);
                }
            }

            if(i >= patternLength -1 && windowCount.equals(patternCount)){
                ans++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = "foxxfoxx";
        String pattern = "fox";

        int res = countAnagram(str, pattern);

        if(res == 0){
            System.out.println("No anagram found");
        }
        else{
            System.out.println(res + " : Anagram found");
        }
    }
}

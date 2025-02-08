package Shreyam.slidingWindow;

import java.util.HashMap;

public class MinimumWindowSize {
    @SuppressWarnings("UnnecessaryUnboxing")
    public static String minWindows(String s, String t){
        if(s.length() == 0 || t.length()== 0) return " ";

        HashMap<Character,Integer> charCountMap = new HashMap<>();
        for(char c: t.toCharArray()){
            charCountMap.put(c,charCountMap.getOrDefault(c, 0)+1);
        }

        int required = charCountMap.size();
        int left=0,right=0,formed=0;

        HashMap<Character,Integer> windowsCount = new HashMap<>();
        int[] minLength = {Integer.MAX_VALUE,0,0};

        while(right<s.length()){
            char c = s.charAt(right);
            windowsCount.put(c,windowsCount.getOrDefault(c, 0)+1);

            if(charCountMap.containsKey(c) &&
                windowsCount.get(c).intValue() == charCountMap.get(c).intValue()){
                    formed++;
                }

                while(left <= right && formed == required){
                    c = s.charAt(left);

                    if(right -left +1 <minLength[0]){
                        minLength[0] = right -left +1;
                        minLength[1] = left;
                        minLength[2] = right;
                    }

                    windowsCount.put(c,windowsCount.get(c) -1);
                    if(charCountMap.containsKey(c) &&
                        windowsCount.get(c).intValue() < charCountMap.get(c).intValue()){
                            formed--;
                        }
                        left++;
                }
                right++;
        }
        return minLength[0] == Integer.MAX_VALUE ? "" :s.substring(minLength[1], minLength[2] +1);
    }
    public static void main(String[] args) {
        String s = "TOMATO";
        String t = "MAT";

        String result = minWindows(s, t);
        System.out.println("Minimum window subString: " + result);
    }
}

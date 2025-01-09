// Question: Print Anagrams Together

// Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

// Note: The final output will be in lexicographic order.

// Examples:

// Input: arr[] = ["act", "god", "cat", "dog", "tac"]
// Output: [["act", "cat", "tac"], ["god", "dog"]]
// Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.


package Shreyam.GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class printAnagramsTogether {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<List<String>> printAnagram(String [] words){
        HashMap<String, List<String>> angramMap = new HashMap<>();

        for(String word : words){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            
            if(!angramMap.containsKey(sorted)){
                angramMap.put(sorted,new ArrayList());
            }
            
            angramMap.get(sorted).add(word);
        }
        List<List<String>> result = new ArrayList<>(angramMap.values());
        for (List<String> group : result) {
            group.sort(String::compareTo);
        }

        return result;
    }
    public static void main(String[] args) {
        String[] arr = {"act","god","cat","dog","tac"};
        List<List<String>> result = printAnagram(arr);
        System.out.println(" ");
        System.out.println(result);
    }
}

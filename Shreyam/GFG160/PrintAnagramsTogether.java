// Question: Print Anagrams Together

// Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.

// Examples:
// Input: arr[] = ["act", "god", "cat", "dog", "tac"]
// Output: [["act", "cat", "tac"], ["god", "dog"]]

package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrintAnagramsTogether {
    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        
        for (String str : arr) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            
            if (!mp.containsKey(sortedStr)) {
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(str);
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (ArrayList<String> group : mp.values()) {
            ans.add(group);
        }
        
        return ans;
    }
    public static void main(String[] args) {
       String arr[] = {"act", "god", "cat", "dog", "tac"};
        System.out.println(anagrams(arr));
    }
}

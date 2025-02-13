// Question: Group Anagram... 
package shreyam.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    // <!---- Brute Force Approach ----> TC: O(nlogn)
    // static List<List<String>> groupAnagram(String [] str){
    //     List<List<String>> result = new ArrayList<>();
    //     boolean[] used = new boolean[str.length];
    //     for(int i=0;i<str.length;i++){
    //         if(!used[i]){
    //             List<String> group = new ArrayList<>();
    //             group.add(str[i]);
    //             used[i] = true;
    //             for (int j = i + 1; j < str.length; j++) {
    //                 if (!used[j] && areAnagrams(str[i], str[j])) {
    //                     group.add(str[j]);
    //                     used[j] = true;
    //                 }
    //             }
    //             result.add(group);
    //             }
    //     }
    //         return result;
    // }
    // private static boolean areAnagrams(String s1, String s2) {
    //     char[] arr1 = s1.toCharArray();
    //     char[] arr2 = s2.toCharArray();
    //     Arrays.sort(arr1);
    //     Arrays.sort(arr2);
    //     return Arrays.equals(arr1, arr2);
    // }

    // <!--- Optimal Approach(Using Sorting) --->TC: O(nlogn)
    // public static List<List<String>> groupAnagram(String[] strs) {
    //     Map<String, List<String>> anagramMap = new HashMap<>();
        
    //     for (String word : strs) {
    //         char[] chars = word.toCharArray();
    //         Arrays.sort(chars);
    //         String key = new String(chars);
            
    //         // Group words by the key
    //         anagramMap.putIfAbsent(key, new ArrayList<>());
    //         anagramMap.get(key).add(word);
    //     }
        
    //     return new ArrayList<>(anagramMap.values());
    // }

    // <!--- Optimal Approach (Frequency Count as Key) ---> TC: O(n)
    public static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            String key = arrayToString(count);
            
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(word);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
            sb.append("#"); 
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String [] str = {"eat","tea","tan","nat","ate","bat"};
        List<List<String>> result = groupAnagram(str);
        System.out.println(result);
    }
}

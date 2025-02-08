// Question:- Word Subsets... 
// You are given two string arrays words1 and words2. A string b is a subset of string a if every letter in b occurs in a including multiplicity.
// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.
// Return an array of all the universal strings in words1. You may return the answer in any order.

// Example 1:
// Input: words1 = ["amazon","apple","facebook","google","leetcode"]
// words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]

package Shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question916 {
    static void setMaxFreq(int[] freq_words2, int[] freq){
            for(int i=0;i<26;i++){
                freq_words2[i] = Math.max(freq_words2[i],freq[i]);
            }
        }
    
        static boolean isUniversal(int[] freq_word, int[] freq_words2){
                for(int i=0;i<26;i++){
                    if(freq_word[i] < freq_words2[i]){
                        return false;
                    }
                }
                return true;
            }
            public static List<String> wordSubsets(String[] words1, String[] words2) {
                int[] freq_words2 = new int[26];
                for(String word:words2){
                    int[] freq = new int[26];
                    for(char c:word.toCharArray()){
                        freq[c-'a']++;
                    }
                    setMaxFreq(freq_words2,freq);
            }
    
            List<String> universal_words = new ArrayList<>();
            for(String word:words1){
                int [] freq_word = new int[26];
                for(char c: word.toCharArray()){
                    freq_word[c-'a']++;
                }
    
                if(isUniversal(freq_word,freq_words2)){
                universal_words.add(word);
            }
        }
        return universal_words;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        List<String> result = wordSubsets(words1, words2);
        
        for(String res:result){
            System.out.println(res);
        }
    }
}

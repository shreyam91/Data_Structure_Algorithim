// Question: Count Vowels Strings in Ranges
// You are given a 0-indexed array of strings words and a 2D array of integers queries.

// Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

// Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

// Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

 

// Example 1:
// Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
// Output: [2,3,0]
// Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
// The answer to the query [0,2] is 2 (strings "aba" and "ece").
// to query [1,4] is 3 (strings "ece", "aa", "e").
// to query [1,1] is 0.
// We return [2,3,0].

package Shreyam.Leetcode;

public class Question2559 {
    private boolean  isVowels(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int [] vowelStrings(String[] words, int [][] queries){
        int n = words.length;
        int [] prefixSum = new int[n+1];

        for(int i=0;i<n;i++){
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length()-1);

            if(isVowels(start) && isVowels(end)){
                prefixSum[i+1] = 1+prefixSum[i];
            }else{
                prefixSum[i+1] = prefixSum[i];
            }
        }

        int [] result = new int [queries.length];
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];  
            int end = queries[i][1];
            result[i] = prefixSum[end+1] -prefixSum[start];
        }

        return result;
    }
    public static void main(String[] args) {
        String words[] = {"aba","bcb","ece","aa","e"};
        int [][] queries = {{0,2},{1,4},{1,1}};

        Question2559 solution = new Question2559();
        int[] result = solution.vowelStrings(words,queries);

        for(int res:result){
            System.out.print(res + " ");
        }
    }
}

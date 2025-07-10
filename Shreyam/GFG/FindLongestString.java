// Question: Find the longest string

// Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 
// Note: If multiple strings have the same maximum length, return the lexicographically smallest one.
// Examples:
// Input: words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
// Output: pros

package shreyam.gfg;

public class FindLongestString {
   static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private static TrieNode root = new TrieNode();

    private static void insert(String word) {
        TrieNode crawler = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true; 
    }

   
    private static boolean search(String word) {
        TrieNode crawler = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            crawler = crawler.children[index];
            if (crawler == null || !crawler.isEndOfWord) {
                return false;  
            }
        }
        return true;
    }
    
    public static String longestString(String[] arr) {
        for (String word : arr) {
            insert(word);
        }

        String result = "";
        for (String word : arr) {
            if (search(word)) {
                if (word.length() > result.length() ||
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
       String words[] = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println(longestString(words));
    }
}

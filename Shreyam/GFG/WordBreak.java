// Question: Word Break... 

// You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].
// Note: From dictionary[], any word can be taken any number of times and in any order.

// Examples :
// Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
// Output: true
// Explanation: s can be breakdown as "i like".

package shreyam.gfg;

class Node {
    Node[] links = new Node[26];
    boolean end = false;
}

public class WordBreak {
    public static Boolean[] dp;
        public static Node root;
                
                public static boolean fun(int index, String s) {
                    if (index >= s.length()) return true;
                    if (dp[index] != null) return dp[index];
                
                Node temp = root;
        for (int j = index; j < s.length(); j++) {
            if (temp.links[s.charAt(j) - 'a'] == null) break;
            temp = temp.links[s.charAt(j) - 'a'];
            if (temp.end && fun(j + 1, s)) {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
    
    public static boolean wordBreak(String s, String[] dictionary) {
            root = new Node();
            for (String str : dictionary) {
                Node temp = root;
                for (char ch : str.toCharArray()) {
                    if (temp.links[ch - 'a'] == null) {
                        temp.links[ch - 'a'] = new Node();
                    }
                    temp = temp.links[ch - 'a'];
                }
                temp.end = true;
            }
            dp = new Boolean[s.length()];
            return fun(0, s);
        }
    
        public static void main(String[] args) {
            String s = "ilike";
            String dictionary[] = {"i", "like", "gfg"};
            System.out.println(wordBreak(s, dictionary));
    }
}

// Question: Word Break... 

// You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].
// Note: From dictionary[], any word can be taken any number of times and in any order.

// Examples :
// Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
// Output: true
// Explanation: s can be breakdown as "i like".

package shreyam.gfg;


class WordBreak {
    static class Node {
        Node[] links = new Node[26];
        boolean isEnd = false;
    }

    private static Node root;
    private static Boolean[] dp;

    private static boolean canBreakFrom(int index, String s) {
        if (index == s.length()) return true;
        if (dp[index] != null) return dp[index];

        Node current = root;
        for (int j = index; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (current.links[ch - 'a'] == null) break;
            current = current.links[ch - 'a'];

            if (current.isEnd && canBreakFrom(j + 1, s)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    private static void insertWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.links[ch - 'a'] == null) {
                temp.links[ch - 'a'] = new Node();
            }
            temp = temp.links[ch - 'a'];
        }
        temp.isEnd = true;
    }

    public static boolean wordBreak(String s, String[] dictionary) {
        root = new Node();
        for (String word : dictionary) {
            insertWord(word);
        }
        dp = new Boolean[s.length()];
        return canBreakFrom(0, s);
    }

    public static void main(String[] args) {
        String s = "ilike";
        String[] dictionary = {"i", "like", "gfg"};
        System.out.println(wordBreak(s, dictionary)); // Output: true
    }
}

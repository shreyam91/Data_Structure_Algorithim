// Question: Implement Trie... 
// Implement Trie class and complete insert(), search() and isPrefix() function for the following queries :
// Type 1 : (1, word), calls insert(word) function and insert word in the Trie
// Type 2 : (2, word), calls search(word) function and check whether word exists in Trie or not.
// Type 3 : (3, word), calls isPrefix(word) function and check whether word exists as a prefix of any string in Trie or not.
// Examples :

// Input: query[][] = [[1, "abcd"], [1, "abc"], [1, "bcd"], [2, "bc"], [3, "bc"], [2, "abc"]]
// Output: [false, true, true]


package shreyam.gfg;

public class ImplementTrie {
        static class Trie {
            boolean end;
            Trie[] children;

        public Trie() {
            end = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie root = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (root.children[idx] == null) {
                    root.children[idx] = new Trie();
                }
                root = root.children[idx];
            }
            root.end = true;
        }

        public boolean search(String word) {
            Trie root = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (root.children[idx] == null) {
                    return false;
                }
                root = root.children[idx];
            }
            return root.end;
        }

        public boolean isPrefix(String prefix) {
            Trie root = this;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (root.children[idx] == null) {
                    return false;
                }
                root = root.children[idx];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        int[][] ops = {
            {1, 0}, {1, 1}, {1, 2}, {2, 3}, {3, 3}, {2, 1}
        };
        String[] words = {
            "abcd", "abc", "bcd", "bc", "bc", "abc"
        };

        for (int i = 0; i < ops.length; i++) {
            int op = ops[i][0];
            String word = words[ops[i][1]];

            switch (op) {
                case 1:
                    trie.insert(word);
                    System.out.println("Inserted: " + word);
                    break;
                case 2:
                    System.out.println("Search \"" + word + "\": " + trie.search(word));
                    break;
                case 3:
                    System.out.println("StartsWith \"" + word + "\": " + trie.isPrefix(word));
                    break;
            }
        }
    }
}

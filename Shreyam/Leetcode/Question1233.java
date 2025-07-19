// Question: Remove Sub-Folders from the Filesystem

// Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
// If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".
// The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
// For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 
// Example 1:
// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]

package shreyam.leetCode;

import java.util.*;

public class Question1233 {
    static class TrieNode {
        boolean wordEnd = false;
        Map<String, TrieNode> child = new HashMap<>();
    }

    private static void trieInsert(String folder, TrieNode curr) {
        int i = 1;
        while (i < folder.length()) {
            StringBuilder name = new StringBuilder();
            while (i < folder.length() && folder.charAt(i) != '/') {
                name.append(folder.charAt(i));
                i++;
            }

            if (curr.wordEnd) return;

            String nameStr = name.toString();
            if (!curr.child.containsKey(nameStr))
                curr.child.put(nameStr, new TrieNode());

            curr = curr.child.get(nameStr);
            i++;
        }
        curr.wordEnd = true;
    }

    private static void searchTrie(TrieNode curr, List<String> res, String path) {
        if (curr == null) return;
        if (curr.wordEnd) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }

        for (Map.Entry<String, TrieNode> entry : curr.child.entrySet()) {
            searchTrie(entry.getValue(), res, path + entry.getKey() + "/");
        }
    }

    public static List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders); 
        TrieNode root = new TrieNode();

        for (String folder : folders)
            trieInsert(folder, root);

        List<String> res = new ArrayList<>();
        searchTrie(root, res, "/");
        return res;
    }

    public static void main(String[] args) {
        String folder[] = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> result = removeSubfolders(folder);
        System.out.println(result); 
    }
}

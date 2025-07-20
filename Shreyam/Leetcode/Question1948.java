// Question: Delete Duplicate Folders in System
 

// Example 1:
// Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
// Output: [["d"],["d","a"]]
// Explanation: The file structure is as shown.
// Folders "/a" and "/c" (and their subfolders) are marked for deletion because they both contain an empty
// folder named "b".


package shreyam.leetCode;

import java.util.*;

public class Question1948 {

    static class TrieNode {
        public Map<String, TrieNode> children = new HashMap<>();
        public boolean deleted = false;
    }

    static class Solution {
        private TrieNode root = new TrieNode();

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, List<TrieNode>> subtreeToNodes = new HashMap<>();

            // Sort the paths by size and lexicographically
            Collections.sort(paths, Comparator.<List<String>>comparingInt(List::size).thenComparing((a, b) -> {
                for (int i = 0; i < Math.min(a.size(), b.size()); ++i) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0) return cmp;
                }
                return 0;
            }));

            // Build Trie
            for (List<String> path : paths) {
                TrieNode node = root;
                for (String s : path) {
                    node.children.putIfAbsent(s, new TrieNode());
                    node = node.children.get(s);
                }
            }

            // Map subtree structures to nodes
            buildSubtreeToRoots(root, subtreeToNodes);

            // Mark duplicates for deletion
            for (List<TrieNode> nodes : subtreeToNodes.values()) {
                if (nodes.size() > 1) {
                    for (TrieNode node : nodes) {
                        node.deleted = true;
                    }
                }
            }

            // Construct final paths
            constructPath(root, new ArrayList<>(), ans);
            return ans;
        }

        private StringBuilder buildSubtreeToRoots(TrieNode node, Map<String, List<TrieNode>> subtreeToNodes) {
            StringBuilder sb = new StringBuilder("(");
            List<String> sortedKeys = new ArrayList<>(node.children.keySet());
            Collections.sort(sortedKeys);  // Ensure consistent traversal

            for (String s : sortedKeys) {
                TrieNode child = node.children.get(s);
                sb.append(s).append(buildSubtreeToRoots(child, subtreeToNodes));
            }

            sb.append(")");
            String subtree = sb.toString();
            if (!subtree.equals("()")) {
                subtreeToNodes.putIfAbsent(subtree, new ArrayList<>());
                subtreeToNodes.get(subtree).add(node);
            }
            return sb;
        }

        private void constructPath(TrieNode node, List<String> path, List<List<String>> ans) {
            List<String> sortedKeys = new ArrayList<>(node.children.keySet());
            Collections.sort(sortedKeys);  // Ensure consistent traversal

            for (String s : sortedKeys) {
                TrieNode child = node.children.get(s);
                if (!child.deleted) {
                    path.add(s);
                    constructPath(child, path, ans);
                    path.remove(path.size() - 1);
                }
            }

            if (!path.isEmpty()) {
                ans.add(new ArrayList<>(path));
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        );

        List<List<String>> result = sol.deleteDuplicateFolder(paths);
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}

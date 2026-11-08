
public class _2_Number_of_distinct_substrings_in_string {
    static class TrieNode {
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String s = "ababa";
        int distinctCount = 0;

        for (int start = 0; start < s.length(); start++) {
            TrieNode node = root;

            for (int end = start; end < s.length(); end++) {
                int index = s.charAt(end) - 'a';

                // A missing child means this substring has not appeared before.
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();

                    // Increase the count because a new trie node represents a new substring.
                    distinctCount++;
                }

                node = node.children[index];
            }
        }

        // Add one more count because the empty substring is also valid.
        distinctCount =+ 1;
    }
}
}

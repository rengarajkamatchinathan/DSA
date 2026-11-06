package trie.theory;

class TrieNode{
    TrieNode[] childs;
    boolean isEnd;

    TrieNode(){
        childs = new TrieNode[26];
        isEnd = false;
    }
}

public class _1_implementation_trie_I {
    static TrieNode root;

    static void insert(String word){
        TrieNode current = root;

        for(char ch:word.toCharArray()){
            int index = getInd(ch);

            //check if character isnt already exist
            if (current.childs[index]==null) {
                current.childs[index] = new TrieNode();
            }

            //even if already exist or new move to next character inside that char
            current = current.childs[index];
        }

        current.isEnd = true;
    }

    static boolean search(String word){
        TrieNode current = root;

        for(char ch:word.toCharArray()){
            int index = getInd(ch);

            if (current.childs[index]==null) {
                return false;
            }
            current = current.childs[index];
        }

        return current.isEnd;
    }
    static boolean startsWith(String prefix) {
        TrieNode current = root;
 
        for (char ch : prefix.toCharArray()) {
            int index = getInd(ch);
 
            // Prefix matching fails as soon as one required path is missing.
            if (current.childs[index] == null) {
                return false;
            }
 
            current = current.childs[index];
        }
 
        return true;
    }
    static int getInd(char c){
        return c - 'a';
    }
    public static void main(String[] args) {
        
        insert("apple");
        search("apple");
        search("app");
        startsWith("app");
        insert("app");
        search("app");

        // Output: true, false, true, true
    }
}

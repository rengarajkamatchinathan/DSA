package trie.theory;

class TrieNode{
    TrieNode[] childs;
    int prefixCnt;
    int wordCnt;

    TrieNode(){
        childs = new TrieNode[26];
    }
}
public class _2_implementation_trie_II {
    static TrieNode root;

    static void insert(String word){
        TrieNode current = root;

        for(char ch:word.toCharArray()){
            int index = getInd(ch);

            //check if character isnt already exist
            if (current.childs[index]==null) {
                current.childs[index] = new TrieNode();
            }

            current.prefixCnt++;

            //even if already exist or new move to next character inside that char
            current = current.childs[index];
        }

        current.wordCnt++;
    }

    static int countWordsEqualTo(String word){
        TrieNode current = root;

        for(char ch:word.toCharArray()){
            int index = getInd(ch);

            if (current.childs[index]==null) {
                return 0;
            }
            current = current.childs[index];
        }

        return current.wordCnt;
    }
    static int countWordsStartingWith(String prefix) {
        TrieNode current = root;
 
        for (char ch : prefix.toCharArray()) {
            int index = getInd(ch);
 
            // Prefix matching fails as soon as one required path is missing.
            if (current.childs[index] == null) {
                return 0;
            }
 
            current = current.childs[index];
        }
 
        return current.prefixCnt;
    }

    static void erase(String word){
        TrieNode current = root;

        for(char ch:word.toCharArray()){
            int index = getInd(ch);
            
            current = current.childs[index];
            current.prefixCnt--;
        }

        current.wordCnt--;
    }
    
    static int getInd(char c){
        return c - 'a';
    }
    public static void main(String[] args) {
        insert("apple");
        insert("apple");
        insert("app");
        countWordsEqualTo("apple");
        countWordsStartingWith("app");
        erase("apple");
        countWordsEqualTo("apple");

        // Output: 2, 3, 1
    }
}

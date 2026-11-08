
class TrieNode{
    TrieNode[] childs;
    boolean isEnd;

    TrieNode(){
        childs = new TrieNode[26];
        isEnd = false;
    }
}

public class _1_longest_word_with_all_prefixes {
    static TrieNode root;
    
    static void insert(String word){
        TrieNode current = root;
        for(char ch:word.toCharArray()){
            int index = getIndex(ch);
            if (current.childs[index]==null) {
                current.childs[index] = new TrieNode();
            }
            current = current.childs[index];
        }
        current.isEnd = true;
    }

    static boolean hasAllPrefix(String word){
        TrieNode current = root;
        for(char ch:word.toCharArray()){
            int index = getIndex(ch);
            if (current.childs[index]==null) {
                return false;
            }
            current = current.childs[index];

            //Each char must have stop flag right for this problem
            //app
            //each character a , p , p has flag stop. bcz previously those word inserted and gotten stop glag
            if (current.isEnd==false) {
                return false;
            }
        }
        
        return true;
    }

    static int getIndex(char c) {return c-'a';}
    public static void main(String[] args) {
        String[] words = {"a", "ap", "app", "appl", "apple", "apply"};
        for(String word:words){
            insert(word);
        }

        String ans = "";

        for(String word:words){
            if (hasAllPrefix(word)) {
                if (word.length()>ans.length() ||
                    word.length()==ans.length() && word.compareTo(ans)<0 ) {
                        ans = word;
                }
            }
        }

        System.out.println(ans);
    }    
}
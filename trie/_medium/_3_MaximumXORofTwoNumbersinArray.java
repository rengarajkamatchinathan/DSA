package trie._medium;

public class _3_MaximumXORofTwoNumbersinArray {
    static class TrieNode {
        TrieNode[] childs = new TrieNode[2];
        boolean contains(int bit) { return childs[bit] != null; }
        void put(int bit) { childs[bit] = new TrieNode(); }
        TrieNode get(int bit) { return childs[bit]; }
    }
    static TrieNode root = new TrieNode();

    static void insert(int num){
        TrieNode curr = root;
        for(int i=31;i>=0;i--){
            //get bit one by one from left -> right
            //01001. get each bit one by one. 0 then 1 -> ...
            int bit = (num>>i) & 1;
            if (!curr.contains(bit)) {
                curr.childs[bit] = new TrieNode();
            }
            curr = curr.get(bit);
        }
    }

    static int getmaxXOR(int num){
        int xor = 0;
        TrieNode curr = root;

        for(int i=31;i>=0;i--){
            //moving nums bit to right side with range of i 
            //then AND with 1 gives 1(if one were there gives 1) or 0
            int bit = (num>>i) & 1;

            //compare num and Trie nodes for existing 1
            if (curr.contains(1-bit)) {
                xor = xor | (1<<i);
                curr = curr.get(1-bit);   
            }else{
                curr = curr.get(bit);
            }
        }

        return xor;
    }
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        // Output: 28
        // Explanation: The maximum result is 5 XOR 25 = 28.

        int res = 0;

        for(int num:nums){
            insert(num);
        }

        for(int num:nums){
            res = Math.max(res, getmaxXOR(num));
        }

        System.out.println(res);
    }
}

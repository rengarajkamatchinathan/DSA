
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
    Node links[] = new Node[2];

    boolean contains(int bit){
        return links[bit]!=null;
    }

    void put(int bit){
        links[bit] = new Node();
    }

    Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root = new Node();

    void insert(int num){
        Node tmp = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;

            if(!tmp.contains(bit)){
                tmp.put(bit);
            }

            tmp = tmp.get(bit);
        }
    }

    int findMax(int num){
        Node tmp = root;
        int maxNum = 0;

        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;

            if(tmp.contains(1-bit)){
                maxNum = maxNum | (1<<i); 
                tmp = tmp.get(1-bit);
            }else{
                tmp = tmp.get(bit);
            }
        }

        return maxNum;
    }
}

public class _4_MaximumXORWithElementFromArray {    
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4}; 
        int[][] queries = {{3,1},{1,3},{5,6}};

        // Output: [3,3,7]
        // Explanation:
        // 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
        // 2) 1 XOR 2 = 3.
        // 3) 5 XOR 2 = 7.

        int[] res = new int[queries.length];
        
        List<int[]> offlineQueries = new ArrayList<>();

        Arrays.sort(nums);

        int ind = 0;
        for(int i[]:queries){
            offlineQueries.add(new int[]{i[0], i[1], ind++});
        }

        offlineQueries.sort((a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();
        int i = 0;

        for(int t[] : offlineQueries){
            // insert elements into trie upto
            while(i<nums.length && nums[i]<=t[1]){
                trie.insert(nums[i]);
                i++;
            }

            if(i!=0)
            res[t[2]] = trie.findMax(t[0]);
            else
            res[t[2]] = -1;
        }

    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    static void alienDic(String[] dict,int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        //1.construct graph by words order
        for(int i=0;i<dict.length-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int len = Math.min(s1.length(), s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        //2.perform topo
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int[] ind = new int[adj.size()];

            //indegree finding...
            for(int i=0;i<adj.size();i++){
                for(int j : adj.get(i)){
                    ind[j]++;
                }
            } 

            //apply bfs
            for(int i=0;i<ind.length;i++){
                if(ind[i]==0){
                    q.add(i);
                }
            }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for(int i : adj.get(node)){
                ind[i]--;
                if(ind[i]==0){
                    q.add(i);
                }
            }
        }

        //3.print topo
        for(int i : res){
            System.out.print((char)(i+((int)'a'))+" ");
        }
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {
            "baa", 
            "abcd", 
            "abca",
            "cab", 
            "cad"
        };
        
        alienDic(dict, K);
    }
}

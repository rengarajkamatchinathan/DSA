package graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _7_alien_dictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        // Output: b d a c

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j)!=s2.charAt(j)) {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        List<Integer> res = bfs(adj);
        for(int i:res){
            System.out.print((char)(i+'a')+" ");
        }
    }

    static List<Integer> bfs(List<List<Integer>> adj){
        List<Integer> res = new ArrayList<>();
        int ind[] = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for(int node:adj.get(i)){
                ind[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i]==0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for(int child:adj.get(node)){
                ind[child]--;
                if (ind[child]==0) {
                    queue.add(child);
                }
            }
        }
        return res;
    }
}

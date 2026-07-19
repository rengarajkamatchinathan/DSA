package graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_detect_cycle_dg {
    static boolean isCyclic(int V, List<List<Integer>> adj){
        int indeg[] = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for(int node = 0; node<V; node++){
            for(int it:adj.get(node)){
                indeg[it]++;
            }
        }

        for(int i=0;i<V;i++){
            if (indeg[i]==0) queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;

            for(int it:adj.get(node)){
                indeg[it]--;
                if (indeg[it]==0) {
                    queue.add(it);
                }
            }
        }

        return cnt!=V;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        //adj.get(4).add(1);

        System.out.println(isCyclic(V, adj));
    }
}

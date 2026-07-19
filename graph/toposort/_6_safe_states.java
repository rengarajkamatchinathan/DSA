package graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _6_safe_states {
    public static void main(String[] args) {
        int V = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(4).add(5);

        //1.Reverse adj
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) revAdj.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for(int node : adj.get(i)){
                revAdj.get(node).add(i);
            }
        }

        //2.indeg form
        int indeg[] = new int[V];
        for (int i = 0; i < V; i++) {
            for(int node:revAdj.get(i)){
                indeg[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for(int child:revAdj.get(node)){
                indeg[child]--;
                if (indeg[child]==0) {
                    queue.add(child);
                }
            }
        }

        System.out.println(res);
    }
}

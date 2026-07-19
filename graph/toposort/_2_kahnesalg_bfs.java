package graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_kahnesalg_bfs {
    public static void main(String[] args) {
        int V = 6; // vertices 0 to 5
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(1).add(3);

        //1.indeg form
        int indeg[] = new int[V];
        for (int i = 0; i < V; i++) {
            for(int j:adj.get(i)){
                //i->j
                indeg[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for(int child:adj.get(node)){
                indeg[child]--;
                if (indeg[child]==0) {
                    queue.add(child);
                }
            }
        }

        System.out.println(res);
    }
}

package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _1_primms_alg {
    public static void main(String[] args) {
        int V = 5, edges[][] =  { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        boolean vis[] = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int dist = pq.peek()[1];
            pq.poll();

            if (vis[node]) {
                continue;
            }

            sum+=dist;
            vis[node] = true;

            for(int child[] : adj.get(node)){
                int child_node = child[0];
                int child_dist = child[1];

                if (!vis[child_node]) {
                    pq.add(new int[]{child_node, child_dist});
                }
            }
        }

        System.out.println(sum);
    }
}

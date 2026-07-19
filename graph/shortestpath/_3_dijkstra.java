package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _3_dijkstra {
    public static void main(String[] args) {
        int V = 5;
        int source = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new int[]{1, 4});
        adj.get(0).add(new int[]{2, 1});
        adj.get(2).add(new int[]{1, 2});
        adj.get(1).add(new int[]{3, 1});
        adj.get(2).add(new int[]{3, 5});
        adj.get(3).add(new int[]{4, 3});

        djikstra(adj, V, source);
    }

    static void djikstra(List<List<int[]>> adj, int V, int src){
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int dist = pq.peek()[1];
            pq.poll();

            for(int[] child:adj.get(node)){
                if (dist + child[1] < dis[child[0]]) {
                    dis[child[0]] = dist + child[1];
                    pq.add(new int[]{child[0], dis[child[0]]});
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}

package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1_unit_weights {
    public static void main(String[] args) {
        int N = 9;
        int[][] edges = {
            {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
            {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        bfs(adj, N, 0);
    }

    static void bfs(List<List<Integer>> adj, int N, int start){
        int dis[] = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int child:adj.get(node)){
                if (dis[node]+1<dis[child]) {
                    dis[child] = dis[node] + 1;
                    queue.add(child);
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}

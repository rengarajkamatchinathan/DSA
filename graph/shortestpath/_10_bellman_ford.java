package graph.shortestpath;

import java.util.Arrays;

public class _10_bellman_ford {

    public static void main(String[] args) {
        int V = 6; 
        //{u,v,w}
        int[][] E = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}}; 
        int S = 0;

        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[S] = 0;
        //Why Repeat N-1 Times? Because the shortest path to any point can involve at most one less edge than the total number of points.
        for (int i = 0; i < V-1; i++) {
            for(int[] it:E){
                int u = it[0];
                int v = it[1];
                int w = it[2];

                if (dis[u]!=Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }

        System.out.println(Arrays.toString(dis));

        //relaxation - checking neg cycle
        for(int[] it:E){
                int u = it[0];
                int v = it[1];
                int w = it[2];

                if (dis[u]!=Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                    //neg cycle
                    System.out.println("negative cycle");
                }
        }

    }
}
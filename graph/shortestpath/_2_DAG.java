package graph.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class _2_DAG {
    public static void main(String[] args) {
        int N = 7;
        int[][] edges = {{0,4,2}, {0,5,3}, {5,4,1}, {4,6,3}, {4,2,1}, {6,1,2}, {2,3,3}, {1,3,1}};

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
    }
}

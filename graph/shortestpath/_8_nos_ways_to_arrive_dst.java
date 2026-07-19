package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _8_nos_ways_to_arrive_dst {
    static class Pair{
        int node;
        int dis;
        Pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public static void main(String[] args) {
        int n = 7, roads[][] = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},
                            {3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int road[]:roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.dis-b.dis);
        int count[] = new int[n];
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        queue.add(new Pair(0, 0));
        dis[0] = 0;
        count[0] = 1;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            
            for(Pair child:adj.get(p.node)){
                if (child.dis + p.dis < dis[child.node]) {
                    dis[child.node] = child.dis + p.dis;
                    queue.add(new Pair(child.node, dis[child.node]));
                    count[child.node] = count[p.node];
                }
                else if(child.dis + p.dis == dis[child.node]){
                    count[child.node] = count[p.node] + count[child.node];
                }
            }
        }

        System.out.println(count[n-1]);
    }
}

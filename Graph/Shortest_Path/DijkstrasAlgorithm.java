package Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int edges[][]={{0,1,4},{0,2,4},{1,2,2},{2,3,3},{2,5,6},{2,4,1},{3,5,2},{4,5,3}};
        int n = 6;
        int src = 0;

        int dis[] = new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int node[] : edges){
            adj.get(node[0]).add(new Pair(node[1], node[2]));
            adj.get(node[1]).add(new Pair(node[0], node[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        pq.add(new Pair(0, 0));
        dis[src] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for(Pair pair : adj.get(p.node)){
                if(p.weight+pair.weight<dis[pair.node]){
                    pq.add(new Pair(pair.node,p.weight+pair.weight));
                    dis[pair.node] = p.weight+pair.weight;
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}

class Pair{
    int node;
    int weight;

    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
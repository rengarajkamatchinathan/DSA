package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _7_network_delay_time {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        //Output: 2
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int time[]:times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u-1).add(new int[]{v-1, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.add(new int[]{k-1, 0});

        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int w = pq.peek()[1];
            pq.poll();

            for(int it[]:adj.get(node)){
                int child = it[0];
                int child_w = it[1];

                if (w + child_w < dis[child]) {
                    dis[child] = w + child_w;
                    pq.add(new int[]{child, dis[child]});
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}

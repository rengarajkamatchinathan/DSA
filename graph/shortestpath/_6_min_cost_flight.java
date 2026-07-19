package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _6_min_cost_flight {
    public static void main(String[] args) {
        int n = 4, flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        //Output: 700

        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int a[]:flights){
            adj.get(a[0]).add(new int[]{a[1], a[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int node = pq.peek()[0];
            int prev_cost = pq.peek()[1];
            int stop = pq.peek()[2];
            pq.poll();

            if (stop>k) {
                continue;
            }

            for(int[] child:adj.get(node)){
                int child_node = child[0];
                int curr_cost = child[1];
                if (curr_cost + prev_cost < cost[child_node]) {
                    cost[child_node] = curr_cost + prev_cost;
                    pq.add(new int[]{child_node, cost[child_node], stop+1});
                }
            }
        }

        System.out.println(Arrays.toString(cost));
    }
}

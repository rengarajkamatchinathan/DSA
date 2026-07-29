package graph.other;

import java.util.ArrayList;
import java.util.List;

public class _1_nos_bridges_tarjans_alg {
    static int timer = 0;
    static void dfs(int node, int par, List<List<Integer>> adj, int time_in[], int low[], boolean vis[], List<List<Integer>> res){
        time_in[node] = low[node] = timer++;
        vis[node] = true;

        for(int child:adj.get(node)){
            if(child==par)continue;

            if (!vis[child]) {
                dfs(child, node, adj, time_in, low, vis, res);
                low[node] = Math.min(low[node], low[child]);
                if (low[child]>time_in[node]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(node);
                    tmp.add(child);
                    res.add(tmp);
                }
            }
            else{
                low[node] = Math.min(low[node], time_in[child]);
            }
        }
    }
    public static void main(String[] args) {
        int N = 12, connection[][]={{1,2}, {1,4}, {2,3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {6, 9}, {8, 9}, {8, 10}, {10, 11}, {10, 12}};
        //Result: [[4, 5], [5, 6], [8, 10]]

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N+1; i++) adj.add(new ArrayList<>());
        for(int a[]:connection){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        int timer_in[] = new int[N+1];
        int low[] = new int[N+1];
        boolean vis[] = new boolean[N+1];
        dfs(1, -1, adj, timer_in, low, vis, res);
        System.out.println(res);
    }
}

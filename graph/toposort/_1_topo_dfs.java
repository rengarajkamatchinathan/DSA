package graph.toposort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1_topo_dfs {
    static void dfs(int node, Stack<Integer> st, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int child:adj.get(node)){
            if (!vis[child]) {
                dfs(child, st, adj, vis);
            }
        }

        st.add(node);
    }
    public static void main(String[] args) {
        int V = 6; // vertices 0 to 5
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(1).add(3);

        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, stack, adj, vis);
            }
        }

        System.out.println(stack);
    }
}

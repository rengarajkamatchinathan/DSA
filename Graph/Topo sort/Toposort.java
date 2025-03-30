import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Toposort {
    static List<Integer> toposort(ArrayList<ArrayList<Integer>> adj, int V){
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            //dfs
            dfs(i, vis, adj, stack);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    static void dfs(int node, boolean[] vis,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        vis[node] = true;
        for(int i : adj.get(node)){
            if (!vis[i]) {
                dfs(i, vis, adj, stack);
            }
        }
        stack.push(node);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println(toposort(adj, V));
    }
}
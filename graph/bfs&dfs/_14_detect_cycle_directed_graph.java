import java.util.ArrayList;

public class _14_detect_cycle_directed_graph {
    static boolean dfs(int node, boolean vis[], boolean pathVis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        for(int N:adj.get(node)){
            if (!vis[N]) {
                return dfs(N, vis, pathVis, adj);
            }
            else if(pathVis[N]) return true;
        }

        pathVis[node] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if (dfs(i, vis, pathVis, adj)) {
                    System.out.println("Cyclic");
                }else{
                    System.out.println("not cyclic");
                }
            }
        }
    }
}

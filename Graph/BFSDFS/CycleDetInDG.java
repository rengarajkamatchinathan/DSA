import java.util.ArrayList;

public class CycleDetInDG {
    static boolean dfs(boolean[] vis,boolean[] pathVis,int node,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        // traverse
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(dfs(vis, pathVis, n, adj)==true){
                    return true;
                }
            }else{
                if(pathVis[n]){
                    return true;
                }
            }
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

        for(int i=1;i<V;i++){
            if (!vis[i]) {
                // DFS
                if(dfs(vis,pathVis,i,adj)==true){
                    System.out.println("YES CONTAINS CYCLE.");
                }
            }
        }
    }
}

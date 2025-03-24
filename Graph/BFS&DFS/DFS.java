import java.util.ArrayList;
import java.util.List;

public class DFS {
    static void dfs(int node,boolean vis[],List<List<Integer>> adj){
        vis[node] = true;
        System.out.print(node+" ");

        for(int i:adj.get(node)){
            if(!vis[i]){
                dfs(i, vis, adj);
            }
        }
    }
    public static void main(String[] args) {
                //Vertices
        int n = 5;
        //Edges
        List<List<Integer>> adj = new ArrayList<>();    
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //Direct Cyclic Graph
        //Add edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);      
        adj.get(4).add(0);

        boolean vis[] = new boolean[n];
        vis[0]=true;

        dfs(0,vis,adj);
    }
}

import java.util.ArrayList;
import java.util.List;

public class _1_nos_of_provinces {
    static void dfs(List<List<Integer>> adj, boolean vis[], int node){
        vis[node] = true;

        for(int child:adj.get(node)){
            if (!vis[child]) {
                dfs(adj, vis, child);
            }
        }
    }
    public static void main(String[] args) {
        // Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        // Output: 2
        // Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
        // Output: 3

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int n = isConnected.length;

        //1.FORM THE GRAPH
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            List<Integer> tmp = new ArrayList<>();

            for(int j=0;j<isConnected[i].length;j++){
                if (isConnected[i][j]==1 && i!=j) {
                    tmp.add(j);
                }
            }
            adj.add(tmp);
        }

        boolean vis[] = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }    
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13_bipartite {
    static boolean dfs(int node, int col, int colors[], List<List<Integer>> adj){
        colors[node] = col;

        for(int child:adj.get(node)){
            if (colors[child]==-1) {
                return dfs(child, 1-col, colors, adj);
            }
            else if (col==colors[child]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int V = 4, E = 4;
        List<List<Integer>>adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        // adj.get(0).add(2);
        // adj.get(2).add(0);
        // adj.get(0).add(3);
        // adj.get(3).add(0);
        // adj.get(1).add(3);
        // adj.get(3).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(2);

        int colors[] = new int[V];
        Arrays.fill(colors, -1);

        System.out.println(dfs(0, 0, colors, adj));
    }
}

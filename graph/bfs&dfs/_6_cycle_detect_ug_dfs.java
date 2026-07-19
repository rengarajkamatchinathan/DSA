import java.util.ArrayList;
import java.util.List;

public class _6_cycle_detect_ug_dfs {

    static boolean isCyclic(int node, int par, List<List<Integer>> adj, int v, boolean[] vis){        
        vis[node] = true;

        for(int child:adj.get(node)){
            if (!vis[child]) {
                return isCyclic(child, node, adj, v, vis);
            }
            else if (par!=child) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int v = 4;
        /*
            0-----1
            |     |
            3-----2
        */
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        
        adjList.get(3).add(0);
        adjList.get(0).add(3);

        boolean[] vis = new boolean[v];
        System.out.println(isCyclic(0,-1, adjList, v, vis));
    }
}

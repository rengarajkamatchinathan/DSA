import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_connected_components {
    static void bfs(List<List<Integer>> adj, int start, boolean vis[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            vis[node] = true;

            for(int child : adj.get(node)){
                if (!vis[child]) {
                    queue.add(child);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(0);

        adjList.get(3).add(4);
        adjList.get(4).add(3);

        boolean vis[] = new boolean[V];
        int cnt = 0;
        for(int i=0;i<V;i++){
            if (!vis[i]) {
                bfs(adjList, i, vis);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

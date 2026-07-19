import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _5_cycle_detect_ug_bfs {

    static boolean isCyclic(List<List<Integer>> adj, int v){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, -1});
        boolean[] vis = new boolean[v];
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int parent = queue.peek()[1];
            queue.poll();

            for(int child:adj.get(node)){
                if (!vis[child]) {
                    queue.add(new int[]{child, node});
                    vis[child] = true;
                }
                else if(child!=parent) return true;
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
        
        // adjList.get(3).add(0);
        // adjList.get(0).add(3);

        System.out.println(isCyclic(adjList, v));
    }
}

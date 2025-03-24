import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
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

        //BFS
        boolean vis[] = new boolean[n];
        // bfs(0, adj, vis);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");

            for(int i:adj.get(node)){
                if(!vis[i]){
                    q.add(i);
                    vis[i]=true;
                }
            }
        }

    } 
}

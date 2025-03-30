package Shortest_Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shortest_Path_UG {
    public static void main(String[] args) {
        int n=9;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int src = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int arr[] : edge){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        int dis[] = new int[n];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = (int)1e9;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            
            for(int adjNode : adj.get(node)){
                int parentDis = dis[node];
                if(dis[adjNode]>parentDis+1){
                    q.add(adjNode);
                    dis[adjNode] = parentDis+1;
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    
    } 
}

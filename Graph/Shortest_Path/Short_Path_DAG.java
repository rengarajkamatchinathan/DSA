package Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Short_Path_DAG {
    static void dfs(Stack<Integer> st, List<List<Pair>> adj,boolean vis[],int node){
        vis[node] = true;
        for(Pair adjNode : adj.get(node)){
            if(!vis[adjNode.node]){
                dfs(st, adj, vis, adjNode.node);
            }
        }
        st.push(node);
    }
    static void toposort(Stack<Integer> st, List<List<Pair>> adj, int n){
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(st, adj, vis, i);
            }
        }
    }
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edges[] : edge){
            adj.get(edges[0]).add(new Pair(edges[1], edges[2]));
        }

        Stack<Integer> st = new Stack<>();
        int[] dis = new int[n];
        for(int i=0;i<dis.length;i++){
            dis[i] = (int)1e9;
        }
        toposort(st, adj, n);
        
        dis[st.peek()] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            
            for(Pair adjPair : adj.get(node)){
                int v = adjPair.node;
                int wt = adjPair.weight;

                if(dis[node]+wt<dis[v]){
                    dis[v] = dis[node]+wt;
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}

class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
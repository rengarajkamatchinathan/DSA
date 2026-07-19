package graph.shortestpath;

import java.util.Arrays;

public class _12_city_with_small_nos_neighbours {
    public static void main(String[] args) {
    int n = 4, edges[][] = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}; 
    int distanceThreshold = 4;
    // Output: 3
    // Explanation: The figure above describes the graph. 
    // The neighboring cities at a distanceThreshold = 4 for each city are:
    // City 0 -> [City 1, City 2] 
    // City 1 -> [City 0, City 2, City 3] 
    // City 2 -> [City 0, City 1, City 3] 
    // City 3 -> [City 1, City 2] 
     int mat[][] = new int[n][n];
     for(int m[]:mat){
        Arrays.fill(m, Integer.MAX_VALUE);
     }

     for(int edge[]:edges){
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        mat[u][v] = w;
        mat[v][u] = w;
     }

     for(int i=0;i<n;i++)mat[i][i] = 0;

     for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][k]!=Integer.MAX_VALUE && mat[k][j]!=Integer.MAX_VALUE){
                    mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }
     }

     int city = -1;
     int city_neigh = Integer.MAX_VALUE;

     for(int i=0;i<n;i++){
        //i-city
        //from i city to these neighbour cities
        int cnt = 0;

        for(int j=0;j<n;j++){
            if(mat[i][j]<=distanceThreshold){
                cnt++;
            }
        }

        if(cnt<=city_neigh){
            city = i;
            city_neigh = cnt;
        }
     }

     System.out.println(city);
    }
}

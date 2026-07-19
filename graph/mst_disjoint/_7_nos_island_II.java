package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.List;

public class _7_nos_island_II {
    static class Disjoint{
        int size[];
        int par[];
        Disjoint(int n){
            size = new int[n];
            par = new int[n];
            for (int i = 0; i < size.length; i++) {
                size[i] = 1;
            }
            for (int i = 0; i < par.length; i++) {
                par[i] = i;
            }
        }

        int getPar(int node){
            if(node==par[node])return node;
            int up = getPar(par[node]);
            par[node] = up;
            return par[node];
        }

        void union(int u, int v){
            int uu = getPar(u);
            int uv = getPar(v);

            if (uu==uv) return;

            if (size[uu]<size[uv]) {
                par[uu] = uv;
                size[uv] += size[uu];
            }
            else{
                par[uv] = uu;
                size[uu] += size[uv];
            }
        }
    }
    public static void main(String[] args) {
        int n = 4, m = 5, coord = 4,
        A[][] = {{1,1},{0,1},{3,3},{3,4}};
        
        Disjoint ds = new Disjoint(n*m);
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        boolean[][] vis= new boolean[n][m];

        for(int a[]:A){
            int i = a[0];
            int j = a[1];

            if (vis[i][j]) {
                continue;
            }

            cnt++;
            vis[i][j] = true;

            int dx[] = {-1,1,0,0};
            int dy[] = {0,0,-1,1};
            for(int k=0;k<4;k++){
                int row = dx[k]+i;
                int col = dy[k]+j;
                if (row>=0&&row<n&&col>=0&&col<m && vis[row][col]) {
                    int u = i*m+j;
                    int v = row*m+col;

                    //not connected so far...
                    if (ds.getPar(u)!=ds.getPar(v)) {
                        ds.union(u, v);
                        cnt--;
                    }
                }
            }

            res.add(cnt);
        }

        System.out.println(res);
    }
}

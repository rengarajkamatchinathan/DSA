package graph.mst_disjoint;

import java.util.HashSet;
import java.util.Set;

public class _8_making_large_island {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };
        //op:3

        //1.FORM COMPONENTS
        int n = grid.length, m = grid[0].length;
        Disjoint disjoint = new Disjoint(n*m);

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==0) continue;

                for(int k=0;k<4;k++){
                    int nr = dx[k] + i;
                    int nc = dy[k] + j;
                    if (nr>=0&&nc>=0&&nr<n&&nc<m && grid[nr][nc]==1) {
                        int node = i*n+m;
                        int child = nr*n+nc;
                        disjoint.union(node, child);
                    }
                }
            }
        }

        //2.FIND THAT 0
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==1) continue;

                Set<Integer> components = new HashSet<>();
                for(int k=0;k<4;k++){
                    int nr = dx[k] + i;
                    int nc = dy[k] + j;
                    if (nr>=0&&nc>=0&&nr<n&&nc<m && grid[nr][nc]==1) {
                        components.add(disjoint.getPar(nr*n+nc));
                    }
                }

                int total_size = 0;
                for(int c:components){
                    total_size += disjoint.size[c];
                }

                ans = Math.max(ans, total_size+1);
            }
        }

        //EDGE CASE FOR ALL 1's
        for (int i = 0; i < n * m; i++) {
            ans = Math.max(ans, disjoint.size[disjoint.getPar(i)]);
        }

        System.out.println(ans);
    }


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
}
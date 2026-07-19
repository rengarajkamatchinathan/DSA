package graph.mst_disjoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _5_most_stones_removed {
    static class DisjointSet{
        int parent[];
        int size[];
        DisjointSet(int n){
            parent = new int[n+1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            size = new int[n+1];
            Arrays.fill(size, 1);
        }

        int getPar(int node){
            if (node==parent[node])
                return node;

            //PATH COMPRESSION
            int ult_par = getPar(parent[node]);
            parent[node] = ult_par;

            return ult_par;
        }

        void unionBySize(int u, int v){
            int ultpar_u = getPar(u);
            int ultpar_v = getPar(v);

            if (ultpar_u==ultpar_v) {
                return;
            }

            if (size[ultpar_u]>size[ultpar_v]) {
                parent[ultpar_v] = ultpar_u;
                size[ultpar_u] = size[ultpar_u] + size[ultpar_v];
            }
            else if(size[ultpar_v]>size[ultpar_u]){
                parent[ultpar_u] = ultpar_v;
                size[ultpar_v] = size[ultpar_u] + size[ultpar_v];
            }
            else{
                //same
                parent[ultpar_u] = ultpar_v;
                size[ultpar_v] = size[ultpar_u] + size[ultpar_v];
            }
        }
    }
    public static void main(String[] args) {
        int n=6 ,stones[][] = {{0, 0},{0, 1}, {1, 0},{1, 2},{2, 1},{2, 2}};
        //op: 5

        int row = 0, col = 0;
        for(int node[] : stones){
            row = Math.max(row, node[0]);
            col = Math.max(col, node[1]);
        }
        
        DisjointSet disjointSet = new DisjointSet(row+col+2);
        Set<Integer> set = new HashSet<>();
        for(int node[] : stones){
            int i = node[0];
            int j = node[1] + row + 1;
            disjointSet.unionBySize(i, j);
            set.add(i);
            set.add(j);
        }

        int c = 0;
        for(int node:set){
            if (disjointSet.getPar(node)==node) {
                c++;
            }
        }

        System.out.println(n-c);
    }
}

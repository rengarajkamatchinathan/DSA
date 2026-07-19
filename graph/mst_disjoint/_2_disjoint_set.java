package graph.mst_disjoint;

import java.util.Arrays;

public class _2_disjoint_set {
    static class DisjointSet{
        int rank[];
        int parent[];
        int size[];
        DisjointSet(int n){
            rank = new int[n+1];
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

        void unionByRank(int u, int v){
            int ultpar_u = getPar(u);
            int ultpar_v = getPar(v);

            if (ultpar_u==ultpar_v) return;

            if (rank[ultpar_u]>rank[ultpar_v]) {
                parent[ultpar_v] = ultpar_u;
            }
            else if(rank[ultpar_v]>rank[ultpar_u]){
                parent[ultpar_u] = ultpar_v;
            }
            else{
                parent[ultpar_v] = ultpar_u;
                rank[ultpar_u] = rank[ultpar_u]+1;
            }
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
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.getPar(3) == ds.getPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
        
        ds.unionByRank(3, 7);
        if (ds.getPar(3) == ds.getPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

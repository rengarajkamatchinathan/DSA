package graph.mst_disjoint;

import java.util.Arrays;

public class _3_Kruskal_alg {
    static class Disjoint{
        int rank[];
        int parent[];
        int size[];
        Disjoint(int n){
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                size[i] = 1;
                parent[i] = i;   
            }
        }

        int getParent(int node){
            if (node==parent[node]) return node;

            int ultimate_parent = getParent(parent[node]);
            parent[node] = ultimate_parent;
            return parent[node];
        }

        void unionByRank(int u, int v){
            int ultimate_parent_u = getParent(u);
            int ultimate_parent_v = getParent(v);
            if (ultimate_parent_u==ultimate_parent_v)
                return;

            if (rank[ultimate_parent_u]<rank[ultimate_parent_v]) {
                parent[ultimate_parent_u] = ultimate_parent_v;
            }
            else if (rank[ultimate_parent_u]>rank[ultimate_parent_v]) {
                parent[ultimate_parent_v] = ultimate_parent_u;
            }
            else{
                parent[ultimate_parent_v] = ultimate_parent_u;
                int rank_v = rank[ultimate_parent_v];
                rank[ultimate_parent_u] = rank_v + 1;
            }
        }
    }
    public static void main(String[] args) {
        int edges[][] = {
            {1,2,2},
            {1,4,1},
            {1,5,4},
            {2,4,3},
            {3,4,5},
            {2,6,7},
            {3,6,8},
            {4,5,9}
        };
        int n = 6+1;
        Arrays.sort(edges, (a,b)->a[2]-b[2]);

        int msmt = 0;
        Disjoint disjoint = new Disjoint(n);
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (disjoint.getParent(u)!=disjoint.getParent(v)) {
                disjoint.unionByRank(u, v);
                msmt+=w;
            }
        }
        System.out.println(msmt);
    }
}

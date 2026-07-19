package graph.mst_disjoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _4_nos_ops_make_network_connected {
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
        int N = 9, M = 8, Edge[][] = {{0,1},{0,2},{0,3},{1,2},{2,3},{4,5},{5,6},{7,8}};
        //op: 2
        //there are 3 components, so for connecting them together, need 2 connections

        DisjointSet disjointSet = new DisjointSet(N);

        for(int e[]:Edge){
            int u = e[0];
            int v = e[1];
            
            disjointSet.unionBySize(u, v);
        }

        Set<Integer> component = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int ult_par = disjointSet.getPar(i);
            component.add(ult_par);
        }

        System.out.println(component.size()-1);
    }
}

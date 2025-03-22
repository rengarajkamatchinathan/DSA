import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    static int findParent(int x, int[] par){
        if(x==par[x])
        return x;

        return par[x] = findParent(par[x], par);
    }

    static void unionByRank(int u, int v, int[] par, int[] rank){
        int ult_p_u = findParent(u, par);
        int ult_p_v = findParent(v, par);
        if(ult_p_u == ult_p_v)
        return;

        if(rank[ult_p_u]==rank[ult_p_v]){
            rank[ult_p_u] = rank[ult_p_u]+1;
            par[ult_p_v]  = ult_p_u;
        }
        else if(rank[ult_p_u]>rank[ult_p_v]){
            par[ult_p_v] = ult_p_u;
        }
        else{
            par[ult_p_u] = ult_p_v;
        }
    }
    public static void main(String[] args) {
        // INPUTS
        List<List<Integer>> edjList = new ArrayList<>();
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}; //u,v,w
        for(int arr[]:edges){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(arr[0]);
            tmp.add(arr[1]);
            tmp.add(arr[2]);
            edjList.add(tmp);
        }

        //Converting edges to adj list
        List<Pair> adjList = new ArrayList<>();
        for(List<Integer> list:edjList){
            adjList.add(new Pair(list.get(0), list.get(1), list.get(2)));
        }
        Collections.sort(adjList);

        int par[] = new int[V];
        int rank[]= new int[V];
        for(int i=0;i<V;i++){
            par[i]=i;
            rank[i]=0;
        }
        int cost = 0;
        for(Pair p:adjList){
            if(findParent(p.src, par)!=findParent(p.des, par)){
                
                unionByRank(p.src, p.des, par, rank);
                cost+=p.weight;
            }
        }
        System.out.println(cost);
    }
}

class Pair implements Comparable<Pair>{
    int src;
    int des;
    int weight;
    Pair(int src,int des,int weight){
        this.src = src;
        this.des = des;
        this.weight = weight;
    }

    public int compareTo(Pair o){
        return this.weight-o.weight;
    }
}
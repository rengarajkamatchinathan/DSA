public class DisjointSetByRank {
    int par[];
    int rank[];

    DisjointSetByRank(int n){
        par = new int[n];
        for(int i=0;i<par.length;i++){
            par[i]=i;
        }
        rank = new int[n];
        for(int i=0;i<rank.length;i++){
            rank[i]=0;
        }
    }
    

    void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v)return;
        if(rank[ulp_u]<rank[ulp_v]){
            par[ulp_u]=ulp_v;
        }
        else if(rank[ulp_u]>rank[ulp_v]){
            par[ulp_v]=ulp_u;
        }
        else{
            rank[ulp_u]=rank[ulp_u]+1;
        }
    }

    int findParent(int n){
        if(n==par[n]){
            return n;
        }
        return par[n]=findParent(par[n]);
    }
    
    public static void main(String[] args) {
        DisjointSetByRank ds = new DisjointSetByRank(8);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        ds.unionByRank(3, 7);

        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

    }
}
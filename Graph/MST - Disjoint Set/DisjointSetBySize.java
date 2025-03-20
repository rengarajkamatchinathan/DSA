public class DisjointSetBySize {
    int par[];
    int size[];

    DisjointSetBySize(int n){
        par = new int[n];
        for(int i=0;i<par.length;i++){
            par[i] = i;
        }
        size = new int[n];
        for(int i=0;i<size.length;i++){
            size[i] = 1;
        }
    }
    

    void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(size[ulp_u]<size[ulp_v]){
            par[ulp_u]=ulp_v;
            size[ulp_v]=size[ulp_u]+size[ulp_v];
        }
        else if(size[ulp_u]>size[ulp_v]){
            par[ulp_v]=ulp_u;
            size[ulp_u]=size[ulp_u]+size[ulp_v];
        }
        else{
            size[ulp_u]=size[ulp_u]+size[ulp_v];
            par[ulp_v] = ulp_u;
        }
    }

    int findParent(int n){
        if(n==par[n]){
            return n;
        }
        return par[n]=findParent(par[n]);
    }
    
    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(8);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        ds.unionBySize(3, 7);

        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

    }
}
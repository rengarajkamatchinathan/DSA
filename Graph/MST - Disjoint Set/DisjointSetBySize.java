public class DisjointSetBySize {
    int size[];
    int par[];

    DisjointSetBySize(int n) {
        size = new int[n];
        par = new int[n];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
            par[i] = i;
        }
    }

    int findParent(int x) {
        if (x == par[x])
            return x;
        return par[x] = findParent(par[x]); // Path compression
    }

    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) {
            return; // Already in the same set
        }

        if (size[ulp_u] < size[ulp_v]) {
            par[ulp_u] = ulp_v;   
            size[ulp_v] += size[ulp_u]; 
        } else {
            par[ulp_v] = ulp_u; 
            size[ulp_u] += size[ulp_v]; 
        }
    }

    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(8);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Checking if 1 and 3 are in the same set
        System.out.println(ds.findParent(1) == ds.findParent(3)); // Expected: true

        // Checking if 4 and 7 are in the same set
        System.out.println(ds.findParent(4) == ds.findParent(7)); // Expected: true

        // Checking if 1 and 5 are in the same set
        System.out.println(ds.findParent(1) == ds.findParent(5)); // Expected: false
    }
}

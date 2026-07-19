package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6_account_merge {
    static class DisjointSet{
    int[] size;
    int parent[];

    // Constructor to initialize DSU
    DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        // Initialize every node
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

        // Function to find ultimate parent with path compression
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        parent[node] = findUPar(parent[node]);
        return parent[node];
    }

    void unionBySize(int u, int v){
        int upu = findUPar(u);
        int upv = findUPar(v);
        if (upu==upv)
            return;

        if (size[upu]<size[upv]) {
            parent[upu] = upv;
            size[upv] += size[upu];
        }else{
            parent[upv] = upu;
            size[upu] += size[upv];            
        }
    }
}

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "j1@com", "j2@com", "j3@com"));
        accounts.add(Arrays.asList("John", "j4@com"));
        accounts.add(Arrays.asList("Raj", "r1@com", "r2@com"));
        accounts.add(Arrays.asList("John", "j1@com", "j5@com"));
        accounts.add(Arrays.asList("Raj", "r2@com", "r3@com"));
        accounts.add(Arrays.asList("Mary", "m1@com"));
        //Output: 
        // [["John","j1@com","j2@com","j3@com","j5@com"],
        // ["John","j4@com"],
        // ["Raj",”r1@com”, “r2@com”,  “r3@com”],
        // ["Mary","m1@com"]]

        DisjointSet disjointSet = new DisjointSet(accounts.size());

        Map<String, Integer> mapMail = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);

                // accounts.add(Arrays.asList("John", "j1@com", "j2@com", "j3@com"));
                // first we encountering these mail
                if (!mapMail.containsKey(mail)) {
                    mapMail.put(mail, i);
                }
                //accounts.add(Arrays.asList("John", "j1@com", "j5@com"));
                //if again encounter those mail, need to union it
                else{
                    disjointSet.unionBySize(i, mapMail.get(mail));
                }
            }
        }

        List<List<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) mergedMails.add(new ArrayList<>());
        for(Map.Entry<String, Integer> it:mapMail.entrySet()){
            String mail = it.getKey();
            int node = disjointSet.findUPar(it.getValue());
            mergedMails.get(node).add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if(mergedMails.get(i).isEmpty())continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(i).get(0));
            Collections.sort(mergedMails.get(i));
            for(String mail:mergedMails.get(i)){
                tmp.add(mail);
            }
            res.add(tmp);
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

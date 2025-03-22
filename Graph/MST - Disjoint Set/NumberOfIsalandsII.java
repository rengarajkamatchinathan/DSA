import java.util.ArrayList;
import java.util.List;

class Disjoint{
    int size[];
    int par[];
    Disjoint(int n){
        size = new int[n];
        par = new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            par[i]=i;
        }
    }

    int findUltPar(int x){
        if(x==par[x]){
            return x;
        }

        return par[x] = findUltPar(par[x]);
    }

    void unionBySize(int u, int v){
        int uu = findUltPar(u);
        int uv = findUltPar(v);
        if(uu==uv) return;

        if (size[uu] < size[uv]) {
            par[uu] = uv;   
            size[uv] += size[uu]; 
        } else {
            par[uv] = uu; 
            size[uu] += size[uv]; 
        }
    }
}

public class NumberOfIsalandsII {

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        boolean vis[][] = new boolean[n][m];

        Disjoint ds = new Disjoint(n*m);

        List<Integer> res = new ArrayList<>();
        
        int count=0;
        for(int arr[]:operators){
           int row = arr[0];
           int col = arr[1];

           if(vis[row][col]==true){
            res.add(count);
            continue;
           }
           vis[row][col]=true;
           count++;

           //check near islands is already existing and connecting current
           int dx[]={0,0,-1,1};
           int dy[]={-1,1,0,0};
           for(int k=0;k<dx.length;k++){
            int new_row = dx[k]+row;
            int new_col = dy[k]+col;
            //validate
            if(new_row>=0&&new_col>=0&&new_row<n&&new_col<m){
                if(vis[new_row][new_col]){
                    int u = row*m+col;
                    int v =new_row*m+new_col;
                    if(ds.findUltPar(u)!=ds.findUltPar(v)){
                        ds.unionBySize(u, v);
                        count--;
                    }
                }
            }
           }

           res.add(count);
        }

        System.out.println(res);
    }
    
}

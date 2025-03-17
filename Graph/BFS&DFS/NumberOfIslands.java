import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands
{
    static void bfs(int mat[][],boolean vis[][],int i,int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();

            int dx[] = {-1,1,0,0};
            int dy[] = {0,0,-1,1};
            
            for(int k=0;k<dx.length;k++){
                int row = p.row+dx[k];
                int col = p.col+dy[k];
                if(row>=0 && col>=0 && row<mat.length && col<mat[0].length){
                    if(mat[row][col]==0 && vis[row][col]==false){
                        q.add(new Pair(row, col));
                        vis[row][col]= true;
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        int mat [][] = {
            {1,1,1,1,1,1},
            {1,1,1,0,0,1},
            {1,1,1,1,1,1},
            {1,0,0,1,1,1},
            {1,0,0,1,1,1}
        };

        boolean vis[][] = new boolean[mat.length][mat[0].length];
        int count = 0;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0 && vis[i][j]==false){
                    bfs(mat, vis, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        
    }
}

class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
    @Override
    public String toString() {
        return "Pair [row=" + row + ", col=" + col + "]";
    }
    
}
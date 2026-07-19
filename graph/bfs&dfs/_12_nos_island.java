public class _12_nos_island {
    static void dfs(char[][] grid, int row, int col, boolean vis[][],
     int dx[], int[] dy,int n, int m){

        vis[row][col] = true;

        for(int i=0;i<4;i++){
            int n_row = row + dx[i];
            int n_col = col + dy[i];

            if(n_row>=0 && n_row<n && n_col>=0 && n_col<m){
                if(grid[n_row][n_col]=='1' && !vis[n_row][n_col]){
                    dfs(grid, n_row, n_col, vis, dx, dy, n, m);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        // Output: 3
        
        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int cnt = 0;

        //traverse and perform dfs
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid, i, j, vis, dx, dy, n, m);
                    cnt++;
                }
            }
        }
    }
}

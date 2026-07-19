import java.util.Arrays;
import java.util.List;

public class _8_surrounded_regions {
    static void dfs(int row, int col, String board[][], boolean[][] vis){
        vis[row][col] = true;

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for (int i = 0; i < 4; i++) {
                int nr = dx[i] + row;
                int nc = dy[i] + col;

                if (nr>=0&&nr<board.length&&nc>=0&&nc<board[0].length && !vis[nr][nc]) {
                    if (board[nr][nc].equals("O")) {
                        dfs(nr, nc, board, vis);
                    }
                }
            }
    }
    public static void main(String[] args) {
        String board[][] = {
            {"X","X","X","X"},
            {"X","O","O","X"},
            {"X","X","O","X"},
            {"X","O","X","X"}};

        //Output: 
        // ["X","X","X","X"],
        // ["X","X","X","X"],
        // ["X","X","X","X"],
        // ["X","O","X","X"]
        
        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];
        //1.traverse outer rows
        for(int i=0;i<m;i++){
            if (!vis[0][i] && board[0][i].equals("O")) {
                dfs(0, i, board, vis);
            }

            if (!vis[n-1][i] && board[n-1][i].equals("O")) {
                dfs(n-1, i, board, vis);
            }
        }

        //2.traverse outer cols
        for(int i=0;i<n;i++){
            if (!vis[i][0] && board[i][0].equals("O")) {
                dfs(i, 0, board, vis);
            }

            if (!vis[i][m-1] && board[i][m-1].equals("O")) {
                dfs(i, m-1, board, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    board[i][j] = "X";
                }
            }
        }

        for(String a[]: board){
            System.out.println(Arrays.toString(a));
        }
    }
}

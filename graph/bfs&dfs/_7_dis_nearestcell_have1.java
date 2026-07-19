import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _7_dis_nearestcell_have1 {
    public static void main(String[] args) {
        int[][] mat = {
            {0,0,0},
            {0,1,0},
            {1,1,1}};
        //{{2,1,2},
        // {1,1,1},
        // {1,1,1}}

        boolean[][] vis = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1) {
                    queue.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};

        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            int dis = queue.peek()[2];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + row;
                int nc = dy[i] + col;

                if (nr>=0&&nr<mat.length&&nc>=0&&nc<mat[0].length && !vis[nr][nc]) {
                    if (mat[nr][nc]==0) {
                        vis[nr][nc] = true;
                        mat[nr][nc] = dis+1;
                        queue.add(new int[]{nr, nc, dis+1});
                    }
                }
            }
        }

        for(int a[]:mat){
            System.out.println(Arrays.toString(a));
        }
    }
}

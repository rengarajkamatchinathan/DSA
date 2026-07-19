import java.util.LinkedList;
import java.util.Queue;

public class _3_rotting_oranges {

    static int bfs(int grid[][]){
        int time = -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];

        //put 2s into queue nd cnt total fresh
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2) {
                    vis[i][j] = true;
                    queue.add(new int[]{i,j, 0});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        int cnt = 0;
        while (!queue.isEmpty()) {
            int a[] = queue.poll();
            time = Math.max(time, a[2]);

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + a[0];
                int nc = dy[i] + a[1];

                if (nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length && !vis[nr][nc]) {
                    if (grid[nr][nc]==1) {
                        queue.add(new int[]{nr, nc, a[2]+1});
                        vis[nr][nc] = true;
                        cnt++;
                    }
                }
            }
        }

        if(cnt!=fresh)return -1;

        return time;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}};
        //every min 2 infects 1. Find min time to infect all. unless return -1 if any unrotten
        //op: 4
        //2 - rotten, 1-fresh, 0-empty cell
        System.out.println(bfs(grid));
    }
}

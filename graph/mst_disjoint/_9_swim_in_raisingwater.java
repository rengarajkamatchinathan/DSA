package graph.mst_disjoint;

import java.util.PriorityQueue;

public class _9_swim_in_raisingwater {
    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        //Output: 16

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        while (!pq.isEmpty()) {
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int diff = pq.peek()[2];
            pq.poll();
            if (i==grid.length-1 && j==grid[0].length-1) {
                System.out.println(diff);
                break;
            }

            for(int k=0;k<4;k++){
                int nr = dx[k] + i;
                int nc = dy[k] + j;
                if (nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length && !vis[nr][nc]) {
                    pq.add(new int[]{nr, nc, Math.max(diff, grid[nr][nc])});
                    vis[nr][nc] = true;
                }
            }
        }
    }
}

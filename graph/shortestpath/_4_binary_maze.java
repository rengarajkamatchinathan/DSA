package graph.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class _4_binary_maze {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {1,1,0},
            {1,1,0}};
        // Output: 4
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        queue.add(new int[]{0,0,1});
        vis[0][0] = true;

        int dirs[][] = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            int d = queue.peek()[2];

            queue.poll();

            if (r==grid.length-1 && c==grid[0].length-1) {
                System.out.println("D="+d);
                break;
            }

            for(int direc[]:dirs){
                int nr = r + direc[0];
                int nc = c + direc[1];

                if (nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length) {
                    if (!vis[nr][nc] && grid[nr][nc]==0) {
                        vis[nr][nc] = true;
                        queue.add(new int[]{nr, nc, d + 1});
                    }
                }
            }
        }


    
    }
}

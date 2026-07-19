package graph.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _5_path_with_mineffort {
    public static void main(String[] args) {
        int[][] heights = {
            {1,2,2},
            {3,8,2},
            {5,3,5}};
        //Output: 2
        //The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.

        int diff[][] = new int[heights.length][heights[0].length];
        for(int d[]:diff) Arrays.fill(d, Integer.MAX_VALUE);
        diff[0][0] = 0;

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});

        while (!pq.isEmpty()) {
            int node[] = pq.poll();
            if (node[0]==heights.length-1 && node[1]==heights[0].length-1) {
                System.out.println(node[2]);
                break;
            }

            for(int i=0;i<4;i++){
                int row = dx[i] + node[0];
                int col = dy[i] + node[1];

                if (row>=0 && row<heights.length && col>=0 && col<heights[0].length) {
                    int abs_diff = Math.abs(heights[row][col] - heights[node[0]][node[1]]);
                    int abs = Math.max(node[2], abs_diff);

                    if (abs<diff[row][col]) {
                        diff[row][col] = abs;
                        pq.add(new int[]{row, col, abs});
                    }
                }
            }
        }
    }
}

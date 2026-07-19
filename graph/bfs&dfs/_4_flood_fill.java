import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _4_flood_fill {
    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}};
        int sr = 1, sc = 1, color = 2;
        //from the source flood will start and color adjacent with color
        // 2 2 2
        // 2 2 0
        // 2 0 1
        
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        boolean vis[][] = new boolean[image.length][image[0].length];
        vis[sr][sc] = true;

        while (!queue.isEmpty()) {
            int a[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + a[0];
                int nc = dy[i] + a[1];

                if (nr>=0&&nr<image.length&&nc>=0&&nc<image[0].length && !vis[nr][nc]) {
                    if (image[nr][nc]==1) {
                        image[nr][nc] = color;
                        vis[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for(int a[]:image){
            System.out.println(Arrays.toString(a));
        }
    }
}

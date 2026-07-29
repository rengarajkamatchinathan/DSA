package dp._2D;

import java.util.Arrays;

public class _4_min_path_sum {
    static int memo(int arr[][], int i, int j, int dp[][]){
        if(i<0||j<0) return Integer.MAX_VALUE;
        if (dp[i][j]!=-1) return dp[i][j];

        if(i==0&&j==0)return arr[i][j];

        int up = Integer.MAX_VALUE;
        if (i>0) {
            up = arr[i][j] + memo(arr, i-1, j, dp);
        }
        int left = Integer.MAX_VALUE;
        if (j>0) {
            left = arr[i][j] + memo(arr, i, j-1, dp);
        }

        return dp[i][j] = Math.min(up, left);
    }

    static int tab(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i==0&&j==0){
                    dp[i][j] = arr[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (i>0) {
                    up = arr[i][j] + dp[i-1][j];
                }
                if (j>0) {
                    left = arr[i][j] + dp[i][j-1];
                }
                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int grid[][] = {
            {1,3,1},
            {1,5,1},
            {4,2,1}};
        // Output: 7
        int dp[][] = new int[grid.length][grid[0].length];
        for(int a[]:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(memo(grid, grid.length-1, grid[0].length-1, dp));
        System.out.println(tab(grid));
    }
}

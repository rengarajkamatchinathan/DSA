package dp._2D;

import java.util.Arrays;

public class _3_grid_uniq_path2 {
    static int memo(int arr[][], int dp[][], int i, int j){
        if (i<0 || j<0 || arr[i][j]==1) {
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if (i==0&&j==0) {
            return 1;
        }

        int left = memo(arr, dp, i, j-1);
        int up = memo(arr, dp, i-1, j);
        return dp[i][j] = up+left;
    }
    static int tab(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (arr[i][j]==1) {
                    continue;
                }
                if (i==0&&j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i>0) {
                    up = dp[i-1][j];
                }
                if (j>0) {
                    left = dp[i][j-1];
                }

                dp[i][j] = up+left;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
        // Output: 2
        // Explanation: There is one obstacle in the middle of the 3x3 grid above.
        // There are two ways to reach the bottom-right corner:
        // 1. Right -> Right -> Down -> Down
        // 2. Down -> Down -> Right -> Right
        int dp[][] = new int[arr.length][arr[0].length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(memo(arr, dp, arr.length-1, arr[0].length-1));
        System.out.println(tab(arr));
    }
}

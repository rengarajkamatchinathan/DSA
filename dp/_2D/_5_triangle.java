package dp._2D;

import java.util.Arrays;

public class _5_triangle {
    static int memo(int i, int j, int arr[][], int dp[][]){
        if (dp[i][j]!=-1) 
            return dp[i][j];

        if (i==arr.length-1) return arr[i][j];

        int down = arr[i][j] + memo(i+1, j, arr, dp);
        int diag = arr[i][j] + memo(i+1, j+1, arr, dp);

        return dp[i][j] = Math.min(down, diag);
    }

    static int tab(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i=0;i<arr[0].length;i++){
            dp[dp.length-1][i] = arr[arr.length-1][i];
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = arr[i][j] + dp[i+1][j];
                int diag = arr[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] triangle = {
            {1,0,0}, 
            {1,2,0}, 
            {1,2,4}};
        // Output: 3
        // Explanation: One possible route can be: 
        // Start at 1st row -> bottom -> bottom.

        int dp[][] = new int[triangle.length][triangle[0].length];
        for(int a[]:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(memo(0, 0, triangle, dp));
        System.out.println(tab(triangle));
    }
}

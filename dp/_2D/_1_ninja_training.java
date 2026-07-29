package dp._2D;

import java.util.Arrays;

public class _1_ninja_training {
    static int memo(int ind, int t, int arr[][], int dp[][]){
        if (dp[ind][t]!=-1) {
            return dp[ind][t];
        }

        int maxi = 0;
        if (ind==0) {
            for(int i=0;i<arr[0].length;i++){
                if (t!=i) {
                    maxi = Math.max(maxi, arr[ind][i]);
                }
            }
            return dp[ind][t] = maxi;
        }

        for(int i=0;i<arr[0].length;i++){
            if (t!=i) {
                int tmp = arr[ind][i] + memo(ind-1, i, arr, dp);
                maxi = Math.max(maxi, tmp);
            }
        }
        return dp[ind][t] = maxi;
    }
    static int tab(int arr[][]){
        int dp[][] = new int[arr.length][4];
        for(int a[]:dp){
            Arrays.fill(a, -1);
        }

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < dp.length; day++) {
            for (int last = 0; last < dp[0].length; last++) {
                int maxi = 0;
                for (int t = 0; t < dp[0].length-1; t++) {
                    if (last!=t) {
                        int tmp_res = arr[day][t] + dp[day-1][t];
                        maxi = Math.max(maxi, tmp_res);
                    }
                }
                dp[day][last] = maxi;
            }
        }

        return dp[arr.length-1][3];
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {10, 40, 70}, 
            {20, 50, 80}, 
            {30, 60, 90}};
        // Output: 210
        // Explanation:
        // Day 1: fighting practice = 70
        // Day 2: stealth training = 50
        // Day 3: fighting practice = 90
        // Total = 70 + 50 + 90 = 210
        // This gives the optimal points.

        int dp[][] = new int[matrix.length][4];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
        System.out.println(memo(matrix.length-1, 3, matrix, dp));
    }
}

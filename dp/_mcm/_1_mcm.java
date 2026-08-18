package dp._mcm;

import java.util.Arrays;

public class _1_mcm {
    static int memo(int arr[], int i, int j, int dp[][]){
        if(i==j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left = memo(arr, i, k, dp);
            int ops = arr[i-1]*arr[k]*arr[j];
            int right = memo(arr, k+1, j, dp);

            int total = left+ops+right;
            mini = Math.min(total, mini);
        }
        return dp[i][j] = mini;
    }

    static int tab(int arr[]){
        int dp[][] = new int[arr.length][arr.length];
        for(int d[]:dp)Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for(int i=dp.length-2;i>0;i--){
            for(int j=i+1;j<dp[0].length;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int left = dp[i][k];
                    int ops = arr[i-1]*arr[k]*arr[j];
                    int right = dp[k+1][j];

                    int total = left+ops+right;
                    mini = Math.min(total, mini);
                }
                dp[i][j] = mini;
            }
        }
      
        return dp[1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int arr[] = {40, 20, 30, 10, 30};
        // Output :  26000 
        // Explanation :  Best parenthesization is ( (A1 x (A2 x A3)) x A4 ).
        int dp[][] = new int[arr.length][arr.length];
        for(int d[]:dp) Arrays.fill(d, -1);
        System.out.println(memo(arr, 1, arr.length-1, dp));
        System.out.println(tab(arr));
    }
}

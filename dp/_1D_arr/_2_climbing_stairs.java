package dp._1D_arr;

import java.util.Arrays;

public class _2_climbing_stairs {
    static int memo(int n, int[] dp){
        if (dp[n]!=-1) {
            return dp[n];
        }
        if (n<2) {
            return dp[n] = 1;
        }

        return dp[n] = memo(n-1, dp)+memo(n-2, dp);
    }

    static int tab(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println("CLIMBING STAIRS");
        int n = 3;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(memo(n, dp));
        System.out.println(Arrays.toString(dp));
        System.out.println(tab(n));
    }
}

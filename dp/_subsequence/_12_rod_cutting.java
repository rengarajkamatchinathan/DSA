package dp._subsequence;

import java.util.Arrays;

public class _12_rod_cutting {
    static int memo(int ind, int N, int price[], int dp[][]){
        if(dp[ind][N]!=-1)return dp[ind][N];

        if(ind==0) return N*price[ind];

        int not_take = memo(ind-1, N, price, dp);
        int take = 0;
        if(ind+1<=N){
            take = price[ind] + memo(ind, N-(ind+1), price, dp);
        }

        return dp[ind][N] = Math.max(not_take, take);
    }
    static int tab(int price[], int N){
        int dp[][] = new int[price.length][N+1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i*price[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for(int n=0;n<dp[0].length;n++){
                int not_take = dp[i-1][n];
                int take = 0;
                if(i+1<=n){
                    take = price[i] + dp[i][n-(i+1)];
                }

                dp[i][n] = Math.max(not_take, take);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        System.out.println("ROD CUTTING");
        int[] price = {1, 6, 8, 9, 10, 19, 7, 20}; int N = 8;
        // Output :25
        // Explanation :Cut the rod into lengths of 2 and 6 for a total price of 6 + 19= 25.
        int dp[][] = new int[price.length][N+1];
        for(int a[]:dp) Arrays.fill(a, -1);
        System.out.println(memo(price.length-1, N, price, dp));
        System.out.println(tab(price, N));
    }
}

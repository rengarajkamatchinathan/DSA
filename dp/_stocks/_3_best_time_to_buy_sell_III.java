package dp._stocks;

import java.util.Arrays;

public class _3_best_time_to_buy_sell_III {
    static int memo(int ind, int buy,int k, int arr[], int dp[][][]){

        if (ind==arr.length || k==0) {
            return 0;
        }
        if (dp[ind][buy][k]!=-1) {
            return dp[ind][buy][k];
        }
        if (buy==1) {
            return dp[ind][buy][k] = Math.max(
                memo(ind+1, buy, k, arr, dp),
                memo(ind+1, 0, k, arr, dp)-arr[ind]
            );
        }
        else{
            return dp[ind][buy][k] = Math.max(
                memo(ind+1, buy, k, arr, dp),
                memo(ind+1, 1, k-1, arr, dp)+arr[ind]
            );
        }
    }

    static int tab(int arr[]){
        int dp[][][] = new int[arr.length+1][2][3];
        for(int ind=arr.length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int k=1;k<3;k++){
                    if (buy==1) {
                        dp[ind][buy][k] = Math.max(
                            dp[ind+1][buy][k],
                            dp[ind+1][0][k]-arr[ind]
                        );
                    }
                    else{
                        dp[ind][buy][k] = Math.max(
                            dp[ind+1][buy][k],
                            dp[ind+1][1][k-1]+arr[ind]
                        );
                    }            
                }
            }
        }
        return dp[0][1][2];
    }
    public static void main(String[] args) {
        int arr[] = {3, 3, 5, 0, 0, 1, 4};
        // MaxProfit = 6 as ((3-0) + (4-1))
        int dp[][][] = new int[arr.length][2][3];
        for(int d[][]:dp){
            for(int a[]:d){
                Arrays.fill(a, -1);
            }
        }
        System.out.println(memo(0, 1, 2, arr, dp));
        System.out.println(tab(arr));
    }
}

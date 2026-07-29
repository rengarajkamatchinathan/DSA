package dp._stocks;

import java.util.Arrays;

public class _2_best_time_to_buy_sell_II {
    static int memo(int ind, int buy, int arr[], int dp[][]){
        if (ind==arr.length) {
            return 0;
        }
        if (dp[ind][buy]!=-1) {
            return dp[ind][buy];
        }
        if (buy==1) {
            return dp[ind][buy] = Math.max(
                memo(ind+1, buy, arr, dp),
                memo(ind+1, 0, arr, dp)-arr[ind]
            );
        }
        else{
            return dp[ind][buy] = Math.max(
                memo(ind+1, buy, arr, dp),
                memo(ind+1, 1, arr, dp)+arr[ind]
            );
        }
    }

    static int tab(int arr[]){
        int dp[][] = new int[arr.length+1][2];
        //skip last row since its base case

        for(int ind=arr.length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if (buy==1) {
                    dp[ind][buy] = Math.max(
                        dp[ind+1][buy],
                        dp[ind+1][0]-arr[ind]
                    );
                }
                else{
                    dp[ind][buy] = Math.max(
                        dp[ind+1][buy],
                        dp[ind+1][1]+arr[ind]
                    );
                }  
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        // MaxProfit=7 as ((5-1) + (6-3))
        int dp[][] = new int[arr.length][2];
        for(int d[]:dp)Arrays.fill(d, -1);
        System.out.println(memo(0, 1, arr, dp));
        System.out.println(tab(arr));
    }
}

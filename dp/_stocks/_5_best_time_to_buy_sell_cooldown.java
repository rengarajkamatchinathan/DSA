package dp._stocks;

import java.util.Arrays;

public class _5_best_time_to_buy_sell_cooldown {
    static int memo(int ind, int buy, int arr[], int dp[][]){
        if (ind>=arr.length) {
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
                memo(ind+2, 1, arr, dp)+arr[ind]
            );
        }
    }

    static int tab(int arr[]){
        int dp[][] = new int[arr.length+2][2];
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
                        dp[ind+2][1]+arr[ind]
                    );
                }  
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int arr[] = {4,9, 0, 4, 10};
        // Max Profit=11 ((9-4)+(10-4))
        int dp[][] = new int[arr.length][2];
        for(int d[]:dp)Arrays.fill(d, -1);
        System.out.println(memo(0, 1, arr, dp));
        System.out.println(tab(arr));
    }
}

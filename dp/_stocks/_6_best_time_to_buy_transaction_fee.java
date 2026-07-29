package dp._stocks;

import java.util.Arrays;

public class _6_best_time_to_buy_transaction_fee {
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
                memo(ind+1, 1, arr, dp)+arr[ind]-2
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
                        dp[ind+1][1]+arr[ind]-2
                    );
                }  
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 8, 4, 9};
        // Fee=2
        // Max Profit=8 (5(8-1-2)+3(9-4-2))

        int dp[][] = new int[arr.length][2];
        for(int d[]:dp)Arrays.fill(d, -1);
        System.out.println(memo(0, 1, arr, dp));
        System.out.println(tab(arr));
    }
}

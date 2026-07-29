package dp._subsequence;

import java.util.Arrays;

public class _7_min_coins {
    static int memo(int ind, int sum, int coins[], int dp[][]){
        if(dp[ind][sum]!=-1)return dp[ind][sum];

        if(ind==0){
            if(sum%coins[0]==0) return sum/coins[0];
            else return Integer.MAX_VALUE;
        }

        int not_pick = memo(ind-1, sum, coins, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[ind]<=sum){
            pick = 1 + memo(ind, sum-coins[ind], coins, dp);
        }

        return dp[ind][sum] = Math.min(not_pick, pick);
    }

    static int tab(int arr[], int amount){
        int dp[][] = new int[arr.length][amount+1];
        for(int sum=0;sum<amount+1;sum++){
            if (sum%arr[0]==0) {
                dp[0][sum] = sum/arr[0];
            }else{
                dp[0][sum] = Integer.MAX_VALUE;
            }
        }

        for(int ind = 1; ind<dp.length; ind++){
            for(int sum=0;sum<amount+1;sum++){
                int not_pick = dp[ind-1][sum];
                int pick = Integer.MAX_VALUE;
                if(arr[ind]<=sum){
                    pick = 1 + dp[ind][sum-arr[ind]];
                }

                dp[ind][sum] = Math.min(not_pick, pick);
            }
        }

        for(int a[]:dp)System.out.println(Arrays.toString(a));

        return dp[dp.length-1][dp[0].length-1];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        // Output: 3
        // Explanation: 11 = 5 + 5 + 1. We need 3 coins to make up the amount 11.

        int dp[][] = new int[coins.length][amount+1];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
        System.out.println(memo(coins.length-1, amount, coins, dp));
        System.out.println(tab(coins, amount));
    }
}

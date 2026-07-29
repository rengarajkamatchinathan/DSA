package dp._subsequence;

import java.util.Arrays;

public class _9_min_coinsII {
    static int memo(int ind, int sum, int coins[], int dp[][]){
        if(dp[ind][sum]!=-1)return dp[ind][sum];

        if(ind==0){
            if(sum%coins[0]==0) return 1;
            else return 0;
        }

        int not_pick = memo(ind-1, sum, coins, dp);
        int pick = 0;
        if(coins[ind]<=sum){
            pick = memo(ind, sum-coins[ind], coins, dp);
        }

        return dp[ind][sum] = pick + not_pick;
    }

    static int tab(int arr[], int amount){
        int dp[][] = new int[arr.length][amount+1];
        for(int sum=0;sum<amount+1;sum++){
            if (sum%arr[0]==0) {
                dp[0][sum] = 1;
            }else{
                dp[0][sum] = 0;
            }
        }

        for(int ind = 1; ind<dp.length; ind++){
            for(int sum=0;sum<amount+1;sum++){
                int not_pick = dp[ind-1][sum];
                int pick = 0;
                if(arr[ind]<=sum){
                    pick = dp[ind][sum-arr[ind]];
                }
                dp[ind][sum] = pick + not_pick;
            }
        }

        for(int a[]:dp)System.out.println(Arrays.toString(a));

        return dp[dp.length-1][dp[0].length-1];
    }
    
    public static void main(String[] args) {
        int[] coins = {2, 4,10}; 
        int amount = 10;
        // Output: 4
        // Explanation: The four combinations are:
        // 10 = 10
        // 10 = 4 + 4 + 2
        // 10 = 4 + 2 + 2 + 2
        // 10 = 2 + 2 + 2 + 2 + 2

        int dp[][] = new int[coins.length][amount+1];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
        System.out.println(memo(coins.length-1, amount, coins, dp));
        System.out.println(tab(coins, amount));
    }
}

package dp._subsequence;

import java.util.Arrays;

public class _11_unbound_knapsack_II {
    static int memo(int ind, int wt, int weights[], int vals[], int dp[][]){
        if(dp[ind][wt]!=-1)return dp[ind][wt];

        if(ind==0){
            return (wt/weights[ind]) * vals[ind];
        }

        int not_pick = memo(ind-1, wt, weights, vals, dp);
        int pick = 0;
        if(weights[ind]<=wt){
            pick = vals[ind] + memo(ind, wt-weights[ind], weights, vals, dp);
        }

        return dp[ind][wt] = Math.max(not_pick, pick);
    }
    static int tab(int W, int weights[], int vals[]){
        int dp[][] = new int[weights.length][W+1];
        for(int wt=weights[0];wt<=W;wt++){
            dp[0][wt] = (wt/weights[0]) * vals[0];
        }

        for(int ind=1;ind<dp.length;ind++){
            for(int wt=0;wt<=W;wt++){
                int not_pick = dp[ind-1][wt];
                int pick = 0;
                if(weights[ind]<=wt){
                    pick = vals[ind] + dp[ind][wt-weights[ind]];
                }

                dp[ind][wt] = Math.max(not_pick, pick);
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int W = 8; 
        int wt[] = {2, 4, 6};
        int val[] = {5, 11, 13};
        //Output: 22

        int dp[][] = new int[wt.length][W+1];
        for(int d[]:dp) Arrays.fill(d, -1);
        System.out.println(memo(wt.length-1, W, wt, val, dp));
        System.out.println(tab(W, wt, val));
    }
}

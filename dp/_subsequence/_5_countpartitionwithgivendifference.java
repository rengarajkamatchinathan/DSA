package dp._subsequence;

import java.util.Arrays;

public class _5_countpartitionwithgivendifference {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        // Output: 3
        // Explanation: The subsets are [1, 2] and [1, 3], [1, 3] and [1, 2], [1, 1, 2] and [3]. 
        
        /*
        Find S1, then search its count thats it
        S1 - S2 = diff
        S1 - (tot-S1) = diff
        2S1 - tot = diff
        S1 = (tot+diff)/2
        */
       int tot = Arrays.stream(arr).sum();
       int S1 = (tot+diff)/2;

        int dp[][] = new int[arr.length][tot+1];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
       System.out.println(memo(arr.length-1, S1, arr, dp));
    }

    static int memo(int ind, int tar, int arr[], int dp[][]){
        if(dp[ind][tar]!=-1) return dp[ind][tar];

        if(tar==0) return dp[ind][tar] = 1;
        if(ind==0) return dp[ind][tar] = arr[0]==tar ? 1 : 0;

        int not_pick = memo(ind-1, tar, arr, dp);
        int pick = 0;
        if(arr[ind]<=tar){
            pick = memo(ind-1, tar-arr[ind], arr, dp);
        }
        return dp[ind][tar] = not_pick + pick;
    }
}

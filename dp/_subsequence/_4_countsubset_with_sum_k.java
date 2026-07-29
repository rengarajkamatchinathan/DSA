package dp._subsequence;

import java.util.Arrays;

public class _4_countsubset_with_sum_k {
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
    static int tab(int arr[], int K){
        int dp[][] = new int[arr.length][K+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        if (arr[0]<=K) {
            dp[0][arr[0]] = 1;
        }

        for(int ind=1;ind<dp.length;ind++){
            for (int tar = 1; tar < dp[0].length; tar++) {
                int not_pick = dp[ind-1][tar];
                int pick = 0;
                if(arr[ind]<=tar){
                    pick = dp[ind-1][tar-arr[ind]];
                }
                dp[ind][tar] = not_pick + pick;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int K = 3;
        // Output: 3
        // Explanation: The subarrays [1,2], [1,2] and [3] have a sum of 3. 
        int dp[][] = new int[arr.length][K+1];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
        System.out.println(memo(arr.length-1, K, arr, dp));
        System.out.println(tab(arr, K));
    }
}

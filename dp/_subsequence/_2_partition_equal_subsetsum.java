package dp._subsequence;

import java.util.Arrays;

public class _2_partition_equal_subsetsum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 3, 4, 5};
        // Output: True
        // Explanation: Nums can be partitioned into two subsets of sum 10.

        /*
        Sum total elements, then search its half in that array.
        */

        int tot = Arrays.stream(nums).sum();
        int subset = tot/2;

        boolean dp[][] = new boolean[nums.length][subset+1];
        System.out.println(memo(nums.length-1, subset, nums, dp));
    }

    static boolean memo(int ind, int tar, int arr[], boolean dp[][]){
        if (dp[ind][tar]!=false) {
            return dp[ind][tar];
        }

        if(ind==0)return dp[ind][tar] = arr[ind]==tar;

        boolean not_pick = memo(ind-1, tar, arr, dp);
        boolean pick = false;
        if(arr[ind]<=tar){
            pick = memo(ind-1, tar-arr[ind], arr, dp);
        }

        return dp[ind][tar] = not_pick || pick;
    }

    static boolean tab(int arr[], int K){
        boolean dp[][] = new boolean[arr.length][K+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true; //if tar == 0 base case
        }
        if (arr[0]<=K) {
            dp[0][arr[0]] = true; //base from memo if ind==0
        }

        for (int ind = 1; ind < dp.length; ind++) {
            for (int tar = 1; tar < dp[0].length; tar++) {
                boolean not_pick = dp[ind-1][tar];
                boolean pick = false;
                if(arr[ind]<=tar){
                    pick = dp[ind-1][tar-arr[ind]];
                }
                dp[ind][tar] = pick || not_pick;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}

package dp._subsequence;

import java.util.Arrays;

public class _3_partition_set_into_twosubsets_withminabsdiff {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        // Output: 0
        // Explanation: Two subsets can be [1,4] and [2,3].

        //construct dp array. We need last row from dp array.
        //last row contains 0->total target for all index of nums.
        //lets say 10 is total, 
        //if tar is 1 then another target is 9 from . FIND ITS DIFF

        int tot = Arrays.stream(nums).sum();
        boolean dp[][] = new boolean[nums.length][tot+1];
        tab(nums, tot, dp);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[dp.length-1][i]==true) {
                int s1 = i;
                int s2 = tot - i;
                ans = Math.min(ans, Math.abs(s1-s2));
            }
        }
        System.out.println(ans);
    }

    static boolean tab(int arr[], int K, boolean dp[][]){
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

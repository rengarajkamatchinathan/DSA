package dp._subsequence;

public class _1_subset_sum_eqtotarget {
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
    public static void main(String[] args) {
        int arrr[] = {4, 3, 5, 2}, K = 6;
        // Output : true
        // Explanation : One possible subset with sum = 6 is [4, 2].
        boolean dp[][] = new boolean[arrr.length][K+1];
        System.out.println(memo(arrr.length-1, K, arrr, dp));
        System.out.println(tab(arrr, K));
    }
}

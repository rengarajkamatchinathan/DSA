package dp._lis;

import java.util.Arrays;

public class _1_lis {
    static int memo(int ind, int prev, int arr[], int dp[][]){
        if (ind==arr.length)
            return 0;

        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int take = 0;
        if(prev==-1 || arr[ind]>=arr[prev]){
            take = 1 + memo(ind+1, ind, arr, dp);
        }
        int nottake = memo(ind+1, prev, arr, dp);

        return dp[ind][prev+1] = Math.max(take, nottake);
    }

    static int tab(int arr[]){
        //+1 row for base case when it reaches that row ->0
        int dp[][] = new int[arr.length+1][arr.length+1];
        for (int ind = arr.length-1; ind>=0; ind--) {
            for(int prev=ind-1;prev>=-1;prev--){
                int take = 0;
                if(prev==-1 || arr[ind]>=arr[prev]){
                    take = 1 + dp[ind+1][ind+1];
                }
                int nottake = dp[ind+1][prev+1];

                dp[ind][prev+1] = Math.max(take, nottake);  
            }
        }

        return dp[0][-1+1];
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  
            // Output:
            // 4  
            // Explanation:
            // The longest increasing subsequence is [2, 3, 7, 101], and its length is 4.
            int dp[][] = new int[nums.length][nums.length];
            for(int a[]:dp)Arrays.fill(a, -1);
            System.out.println(memo(0, -1, nums, dp));
            System.out.println(tab(nums));
    }
}

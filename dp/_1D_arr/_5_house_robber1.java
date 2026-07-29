package dp._1D_arr;

import java.util.Arrays;

public class _5_house_robber1 {
    static int memo(int ind, int arr[], int dp[]){
        if(ind<0) return 0;
        if(dp[ind]!=-1)return dp[ind];
        if(ind==0)return arr[ind];

        int not_pick = memo(ind-1, arr, dp);
        int pick = arr[ind] + memo(ind-2, arr, dp);

        return dp[ind] = Math.max(not_pick, pick);
    }

    static int tab(int nums[]){
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int ind=2;ind<nums.length;ind++){
            int not_pick = dp[ind-1];
            int pick = nums[ind] + dp[ind-2];

            return dp[ind] = Math.max(not_pick, pick); 
        }
        return dp[nums.length-1];
    }

    static int tab_optimized(int nums[]){
        int prev = nums[0];
        int prev2 = 0;

        for(int ind=1;ind<nums.length;ind++){
            int not_pick = prev;
            int pick = nums[ind] + prev2;

            int curr = Math.max(not_pick, pick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        // Output: 4
        // Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        // Total amount you can rob = 1 + 3 = 4.
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(nums.length-1, nums, dp));
        System.out.println(tab(nums));
        System.out.println(tab_optimized(nums));
    }
}

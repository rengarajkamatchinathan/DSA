package dp._1D_arr;

import java.util.Arrays;

public class _4_jumping_frog_ksteps {
    static int memo(int ind, int arr[], int k, int[] dp){
        if(ind==0) return dp[ind] = 0;

        if (dp[ind]!=-1) {
            return dp[ind];
        }
        int mm = Integer.MAX_VALUE;
        for(int step=1;step<=k;step++){
            if (ind-step>=0) {
                int jump = memo(ind-step, arr, k, dp) + Math.abs(arr[ind] - arr[ind-step]);
                mm = Math.min(jump, mm);
            }
        }
        return dp[ind] = mm;
    }

    static int tab(int arr[], int k){
        int dp[] = new int[arr.length];
        dp[0] = 0;
        for(int ind = 1;ind<arr.length;ind++){
            int mm = Integer.MAX_VALUE;
            for(int step=1;step<=k;step++){
                if (ind-step>=0) {
                    int jump = dp[ind-step] + Math.abs(arr[ind] - arr[ind-step]);
                    mm = Math.min(jump, mm);
                }
            }
            dp[ind] = mm;
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println("FROM JUMP WITH K STEPS");
        int[] heights = {10, 5, 20, 0, 15};
        int k=2;
        // Output: 15
        // Explanation:
        // 0th step -> 2nd step, cost = abs(10 - 20) = 10
        // 2nd step -> 4th step, cost = abs(20 - 15) = 5
        // Total cost = 10 + 5 = 15.
        int dp[] = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(heights.length-1, heights, k, dp));
        System.out.println(tab(heights, k));
    }   
}

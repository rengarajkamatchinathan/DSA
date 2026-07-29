package dp._1D_arr;

import java.util.Arrays;

public class _3_jumping_frog {
    static int memo(int ind, int arr[], int[] dp){
        if(ind==0) return dp[ind] = 0;

        if (dp[ind]!=-1) {
            return dp[ind];
        }

        int jumpone = memo(ind-1, arr, dp) + Math.abs(arr[ind] - arr[ind-1]);
        int jumptwo = Integer.MAX_VALUE;
        if (ind>1) {
            jumptwo = memo(ind-2, arr, dp) + Math.abs(arr[ind] - arr[ind-2]);
        }
        return dp[ind] = Math.min(jumpone, jumptwo);
    }

    static int tab(int arr[]){
        int dp[] = new int[arr.length];
        arr[0] = 0;
        for(int ind = 1;ind<arr.length;ind++){
            int jumpone = dp[ind-1] + Math.abs(arr[ind] - arr[ind-1]);
            int jumptwo = Integer.MAX_VALUE;
            if (ind>1) {
                jumptwo = dp[ind-2] + Math.abs(arr[ind] - arr[ind-2]);
            }
            dp[ind] = Math.min(jumpone, jumptwo);
        }
        return dp[arr.length-1];
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 3, 5, 4};
        // Output: 2
        // Explanation: One possible route can be,
        // 0th step -> 2nd Step = abs(2 - 3) = 1
        // 2nd step -> 4th step = abs(3 - 4) = 1
        // Total = 1 + 1 = 2.
        int dp[] = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(heights.length-1, heights, dp));
        System.out.println(tab(dp));
    }   
}

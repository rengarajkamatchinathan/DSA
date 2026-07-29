package dp._lis;

import java.util.Arrays;

public class _7_nos_lis {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        // Output: 2
        // Explanation: There are two LIS of length 4: [1, 3, 4, 7] and [1, 3, 5, 7].
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = -1;
        int cnt[] = new int[nums.length];
        Arrays.fill(cnt, 1);

        for(int ind=1;ind<nums.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if (nums[prev]<=nums[ind] && dp[prev]+1>dp[ind]) {
                    dp[ind] = dp[prev] + 1;
                    cnt[ind] = cnt[prev];
                }
                else if (nums[prev]<=nums[ind] && dp[prev]+1==dp[ind]) {
                    cnt[ind] = cnt[ind] + cnt[prev];
                }
            }
        }

        System.out.println(Arrays.stream(cnt).max().getAsInt());
    }
}

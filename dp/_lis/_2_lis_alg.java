package dp._lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_lis_alg {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  
        // Output:
        // 4  
        // Explanation:
        // The longest increasing subsequence is [2, 3, 7, 101], and its length is 4.
        int dp[] = new int[nums.length];
        int par[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0;i<par.length;i++)par[i]=i;
        int ans = -1;
        int last_ind = -1;


        for(int ind=1;ind<nums.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if (nums[prev]<=nums[ind] && dp[prev]+1>dp[ind]) {
                    dp[ind] = dp[prev] + 1;
                    par[ind] = prev;

                    if(dp[ind]>ans){
                        ans = dp[ind];
                        last_ind = ind;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (last_ind!=par[last_ind]) {
            res.add(nums[last_ind]);
            last_ind = par[last_ind];
        }
        res.add(nums[last_ind]);
        System.out.println(res);
    }
}

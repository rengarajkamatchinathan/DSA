package dp._lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_longest_divisible_subset {
    public static void main(String[] args) {
        int[] nums = {3, 5, 10, 20};  
        // Output:
        // [5, 10, 20]  
        // Explanation:
        // The subset [5, 10, 20] satisfies the divisibility condition:  
        // - 10 % 5 == 0  
        // - 20 % 10 == 0  

        int dp[] = new int[nums.length];
        int par[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0;i<par.length;i++)par[i]=i;
        int ans = -1;
        int last_ind = -1;


        for(int ind=1;ind<nums.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if (nums[ind]%nums[prev]==0 && dp[prev]+1>dp[ind]) {
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

package dp._lis;

import java.util.Arrays;

public class _6_biotonic_subseq {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3, 6, 8, 7};
        // Output:
        // 6  
        // Explanation:
        
        // The longest bitonic sequence is [1, 2, 3, 6, 8, 7] with a length of 6.  
        // The sequence increases from 1 to 8 and then decreases at 7.

        int dp1[] = new int[arr.length];
        int dp2[] = new int[arr.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int ind=1;ind<arr.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if (arr[prev]<=arr[ind] && dp1[prev]+1>dp1[ind]) {
                    dp1[ind] = dp1[prev] + 1;
                }
            }
        }

        for(int ind=arr.length-1;ind>0;ind--){
            for(int prev=arr.length-1;prev>ind;prev--){
                if (arr[prev]<=arr[ind] && dp2[prev]+1>dp2[ind]) {
                    dp2[ind] = dp2[prev] + 1;
                }
            }
        }

        int maxi = 0;
        for(int i=0;i<dp1.length;i++){
            maxi = Math.max(maxi, dp1[i]+dp2[i]-1);
        }
        System.out.println(maxi);
    }
}

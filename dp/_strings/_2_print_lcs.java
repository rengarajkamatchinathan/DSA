package dp._strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_print_lcs {
    static int tab(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.max(
                    dp[i-1][j],
                    dp[i][j-1]
                );
            }
        }

        for(int a[]:dp)System.out.println(Arrays.toString(a));
        List<Character> res = new ArrayList<>();
        int i=dp.length-1, j=dp[0].length-1;
        while (i>0 && j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                res.add(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]<dp[i-1][j]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(res);
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        String str1 = "apple", str2 = "waffle";
        // Output: 3 - "ale" 
        // Explanation: LCS of two strings is "ale".
        System.out.println(tab(str1, str2));
    }
}

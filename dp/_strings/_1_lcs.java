package dp._strings;

import java.util.Arrays;

public class _1_lcs {
    static int memo(int i, int j, String s1, String s2, int dp[][]){
        if(i<0 || j<0) return 0;

        if (dp[i][j]!=-1) {
            return dp[i][j];
        }

        if (s1.charAt(i)==s2.charAt(j)) {
            return dp[i][j] = 1 + memo(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(
            memo(i-1, j, s1, s2, dp),
            memo(i, j-1, s1, s2, dp)
        );
    }

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
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        String str1 = "apple", str2 = "waffle";
        // Output: 3 - "ale" 
        // Explanation: LCS of two strings is "ale".
        int dp[][] = new int[str1.length()][str2.length()];
        for(int d[]:dp)Arrays.fill(d, -1);
        System.out.println(memo(str1.length()-1, str2.length()-1, str1, str2, dp));
        System.out.println(tab(str1, str2));
    }
}

package dp._strings;

import java.util.Arrays;

public class _8_distinct_subseq {
    static int memo(int i, int j, String s, String t, int dp[][]){
        if (i==s.length()) {
            return 0;
        }
        if (j==t.length()) {
            return 1;
        }

        if(dp[i][j]!=-1)return dp[i][j];

        if (s.charAt(i)==t.charAt(j)) {
            int take = memo(i+1, j+1, s, t, dp);
            int nottake = memo(i+1, j, s, t, dp);
            dp[i][j] = take + nottake;
        }
        else{
            dp[i][j] = memo(i+1, j, s, t, dp);
        }
        return dp[i][j];
    }

    static int tab(String s, String t){
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][m] = 1;
        }

        for (int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--){
                if (s.charAt(i)==t.charAt(j)) {
                    int take = dp[i+1][j+1];
                    int nottake = dp[i+1][j];
                    dp[i][j] = take + nottake;
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        String s="axbxax";
        String t="axa";
        // op: 2 // there are two diff axa in s (ax)bx(a)x and (a)b(xa)x
        int dp[][] = new int[s.length()][t.length()];
        for(int d[]:dp)Arrays.fill(d, -1);
        System.out.println(memo(0, 0, s, t, dp));  
        System.out.println(tab(s, t));
    }
}

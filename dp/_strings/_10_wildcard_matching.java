package dp._strings;

import java.util.Arrays;

public class _10_wildcard_matching {
    static boolean isAllStars(String s, int i){
        for(int j=0;j<=i;j++){
            if(s.charAt(j)!='*') return  false;
        }
        return true;
    }
    static boolean memo(int i, int j, String s1, String s2, boolean[][] dp){
        if (i==0&&j==0)
            return true;
        if (i==0&&j>0) return false;
        if (j==0 && i>0) return isAllStars(s1,i);

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return dp[i][j] = memo(i-1, j-1, s1, s2, dp);
        }
        else if(s1.charAt(i)=='*'){
            return dp[i][j] = memo(i-1, j, s1, s2, dp) || memo(i, j-1, s1, s2, dp);
        }
        return dp[i][j] = false;
    }
    static boolean tab(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 1; i <=n; i++) {
            dp[i][0] = isAllStars(s1, i);
        }
        for (int i = 1; i <=m; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else 
                dp[i][j] = false;
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";
        // Output: true

        boolean dp[][] = new boolean[S1.length()][S2.length()];
        System.out.println(memo(S1.length()-1, S2.length()-1, S1, S2, dp));
        System.out.println(tab(S1, S2));
    }
}

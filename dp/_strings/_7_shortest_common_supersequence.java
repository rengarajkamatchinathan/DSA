package dp._strings;

import java.util.Arrays;

public class _7_shortest_common_supersequence {
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

        int i = dp.length-1, j = dp[0].length-1;
        String res = "";
        while (i>0&&j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                res+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                res+=s1.charAt(i-1);
                i--;
            }
            else{
                res+=s2.charAt(j-1);
                j--;
            }
        }

        while (i>0) {
            res+=s1.charAt(i-1);
            i--;
        }
        while (j>0) {
            res+=s2.charAt(j-1);
            j--;
        }
        
        System.out.println(new StringBuilder(res).reverse());

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        //bgruoote
        System.out.println(tab(s1, s2));
    }
}

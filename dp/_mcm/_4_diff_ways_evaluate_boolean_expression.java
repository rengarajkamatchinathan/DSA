package dp._mcm;

import java.util.Arrays;

public class _4_diff_ways_evaluate_boolean_expression {
    static int memo(int i, int j, int isTrue,String str, int dp[][][]){
        if(i>j)return 0;
        if(dp[i][j][isTrue]!=-1)return dp[i][j][isTrue];
        if(i==j){
            if (isTrue==1) return str.charAt(i)=='T'?1:0;
            else return str.charAt(i)=='F'?1:0;
        }

        int ways = 0;
        for (int k = i+1; k <= j; k=k+2) {
            int lt = memo(i, k-1, isTrue, str, dp);
            int lf = memo(i, k-1, 0, str, dp);
            int rt = memo(k+1, j, isTrue, str, dp);
            int rf = memo(k+1, j, 0, str, dp);

            if (str.charAt(k)=='&') {
                if (isTrue==1) {
                    ways += lt*rt;
                }
                else{
                    ways += (lt*rf) + (lf*rt) + (lf*rf);
                }
            }
            else if(str.charAt(k)=='|'){
                if (isTrue==1) {
                    ways += (lt*rf) + (lf*rt) + (lt*rt);
                }
                else{
                    ways += (lf*rf);
                }                
            }
            else{
                if (isTrue==1) {
                    ways += (lf*rt) + (lt*rf);
                }
                else{
                    ways += (lt*rt) + (lf*rf);
                }
            }
        }

        return dp[i][j][isTrue] = ways;
    }
    public static void main(String[] args) {
        String expression = "F|T^F";
        // Output: 2
        // Explanation: There are 2 possible ways to get the result as true:
        //         i. (F|T) ^ F = T ^ F = T
        //         ii. F | (T^F) = F | T = T
        int dp[][][] = new int[expression.length()][expression.length()][2];
        for(int d[][]:dp){
            for(int a[]:d){
                Arrays.fill(a, -1);
            }
        }
        System.out.println(memo(0, expression.length()-1, 1, expression, dp));
    }
}

package dp._mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _2_min_cuts {
    static int memo(int i, int j, List<Integer> cuts, int dp[][]){
        if(i>j)return 0;

        if (dp[i][j]!=-1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cut = cuts.get(j+1) - cuts.get(i-1);
            int left = memo(i, k-1, cuts, dp);
            int right = memo(k+1, j, cuts, dp);

            int total = cut + left + right;
            mini = Math.min(mini, total);
        }

        return dp[i][j] = mini;
    }

    static int tab(int cuts[], int n){
        List<Integer> cutss = new ArrayList<>();
        for(int c:cuts)cutss.add(c);
        cutss.add(0);
        cutss.add(n);
        Collections.sort(cutss);

        int dp[][] = new int[cutss.size()][cutss.size()];
        for (int i = cutss.size()-1; i > 0; i--) {
            for(int j=i;j<cutss.size()-1;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cut = cutss.get(j+1) - cutss.get(i-1);
                    int left = dp[i][k-1];
                    int right = dp[k+1][j];

                    int total = cut + left + right;
                    mini = Math.min(mini, total);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][cutss.size()-2];
    }
    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        int n = 7;
        //Output: 16
        List<Integer> cutss = new ArrayList<>();
        for(int c:cuts)cutss.add(c);
        cutss.add(0);
        cutss.add(n);
        Collections.sort(cutss);

        int dp[][] = new int[cutss.size()][cutss.size()];
        for(int d[]:dp) Arrays.fill(d, -1);
        System.out.println(memo(1, cutss.size()-2, cutss, dp));
        System.out.println(tab(cuts, n));
    }
}

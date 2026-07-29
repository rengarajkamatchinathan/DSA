package dp._2D;

import java.util.Arrays;

public class _6_cherry_pickup {
    static int memo(int i, int j1, int j2, int arr[][], int dp[][][]){
        if (j1<0||j1>arr[0].length-1 || j2<0||j2>arr[0].length-1)
            return Integer.MIN_VALUE;

        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];

        if (i==arr.length-1) {
            return j1==j2?arr[i][j1]:arr[i][j1]+arr[i][j2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int di=-1;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                if (j1==j2) {
                    int res = arr[i][j1] + memo(i+1, j1+di, j2+dj, arr, dp);
                    maxi = Math.max(maxi, res);
                }else{
                    int res = arr[i][j1] + arr[i][j2] + memo(i+1, j1+di, j2+dj, arr, dp);
                    maxi = Math.max(maxi, res);
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    static int tab(int arr[][], int jack1, int jack2){
        int dp[][][] = new int[arr.length][arr[0].length][arr[0].length];
        int n = arr.length;
        int m = arr[0].length;

        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if (j1==j2) {
                    dp[n-1][j1][j2] = arr[n-1][j1];
                }else{
                    dp[n-1][j1][j2] = arr[n-1][j1] + arr[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                int maxi = Integer.MIN_VALUE;
                for(int di=-1;di<=1;di++){
                    for(int dj=-1;dj<=1;dj++){
                    int ans;
                    if (j1 + di >= 0 && j1 + di < m &&
                        j2 + dj >= 0 && j2 + dj < m) {

                        ans = dp[i + 1][j1 + di][j2 + dj];
                    } else {
                        ans = Integer.MIN_VALUE;
                    }

                    if (j1 == j2)
                        ans += arr[i][j1];
                    else
                        ans += arr[i][j1] + arr[i][j2];

                    maxi = Math.max(maxi, ans);
                    }
                }
                dp[i][j1][j2] = maxi;
            }
        }
        }

        return dp[0][jack1][jack2];
    }
    public static void main(String[] args) {
        int arr[][] = {
            {3,4,1,2},
            {2,3,1,2},
            {5,6,3,5}
        };
        //op: 21
        int dp[][][] = new int[arr.length][arr[0].length][arr[0].length];
        for(int d[][]:dp){
            for(int a[]:d){
                Arrays.fill(a, -1);
            }
        }
        System.out.println(memo(0, 0, arr[0].length-1, arr, dp));
        System.out.println(tab(arr, 0, arr[0].length-1));
    }
}

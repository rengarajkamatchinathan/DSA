package dp._strings;

public class _9_edit_dist {
    static int memo(int i, int j, String start, String target){
        if (i<0) {
            return j+1;
        }
        if (j<0) {
            return i+1;
        }
        if (start.charAt(i)==target.charAt(j)) {
            return memo(i-1, j-1, start, target);
        }
        else{
            return 1 + Math.min(
                memo(i-1, j-1, start, target),    //updated a matching char to start and move on
                Math.min(
                    memo(i-1, j, start, target),//removed a char from start
                    memo(i, j-1, start, target) //inserted a char to start and move on
                )
            );
        }
    }
    static int tab(String start, String target){
        int n = start.length();
        int m = target.length();
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <=n; i++) {
            for(int j=1;j<=m;j++){
                if (start.charAt(i-1)==target.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j-1],    //updated a matching char to start and move on
                        Math.min(
                            dp[i-1][j],//removed a char from start
                            dp[i][j-1]) //inserted a char to start and move on
                    );
                }  
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String start = "abcdefg";
        String target = "azced";
        // Output: 4
        // Explanation:
        // To transform "abcdefg" into "azced", the following operations are required:
        // 1. Replace 'b' with 'z': "abcdefg" -> "azcdefg"
        // 2. Delete 'd': "azcdefg" -> "azcefg"
        // 3. Delete 'f': "azcefg" -> "azceg"
        // 4. Replace 'g' with 'd': "azceg" -> "azced"
        // Thus, a total of 4 operations are needed.
        System.out.println(memo(start.length()-1, target.length()-1, start, target));
        System.out.println(tab(start, target));
    }
}

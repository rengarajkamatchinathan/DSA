package dp._strings;

public class _3_longest_comm_substring {
    static int tab(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        int maxi = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxi = Math.max(maxi, dp[i][j]);
                    continue;
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        String str1 = "abcde", str2 = "abfce";  
        // Output:
        // 2  
        // Explanation:
        // The longest common substring is "ab", which has a length of 2.
        System.out.println(tab(str1, str2));
    }
}

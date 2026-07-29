package dp._strings;

public class _5_insertions_tomake_string_palindrome {
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
        String s = "abcaa";
        // Output: 2
        // Explanation: Insert 2 characters "c", and "b" to make "abcacba", which is a palindrome.

        String s1 = s;
        String s2 = new StringBuffer(s).reverse().toString();

        int lcs = tab(s1, s2);

        int insertions = s1.length() - lcs;
        System.out.println(insertions);
    }
}

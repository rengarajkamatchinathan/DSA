package dp._squares;

public class _2_square_submatrices {     
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},
                          {1,1,1,1},
                          {0,1,1,1}};
        // Output: 15
        // Explanation: 
        // There are 10 squares of size 1.
        // There are 4 squares of size 2.
        // There is  1 square of size 3.
        // Total number of squares = 10 + 4 + 1 = 15.

        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j]==1) {
                    dp[i][j] = 1 + Math.min(
                                        dp[i][j-1],
                                        Math.min(
                                            dp[i-1][j],
                                            dp[i-1][j-1]
                                        )
                            );
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                sum+=dp[i][j];
            }
        }
        System.out.println(sum);
    }
}
